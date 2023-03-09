package com.gt.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.google.code.kaptcha.util.Config;

@Configuration
public class KaptchaConfig {
	@Bean
    public ServletRegistrationBean<KaptchaServlet> servletRegistrationBean() {
        ServletRegistrationBean<KaptchaServlet> bean = new ServletRegistrationBean<>(new KaptchaServlet(), "/kaptcha.jpg");
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put(Constants.KAPTCHA_BORDER, "yes");
        initParameters.put(Constants.KAPTCHA_BORDER_COLOR, "black");
        initParameters.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "blue");
        initParameters.put(Constants.KAPTCHA_IMAGE_WIDTH, "200");
        initParameters.put(Constants.KAPTCHA_IMAGE_HEIGHT, "50");
        initParameters.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890");
        initParameters.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "6");
        initParameters.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "40");
        initParameters.put(Constants.KAPTCHA_NOISE_IMPL, "com.google.code.kaptcha.impl.NoNoise");
        initParameters.put(Constants.KAPTCHA_OBSCURIFICATOR_IMPL, "com.google.code.kaptcha.impl.ShadowGimpy");
        initParameters.put(Constants.KAPTCHA_TEXTPRODUCER_IMPL, "com.google.code.kaptcha.text.impl.DefaultTextCreator");
        initParameters.put(Constants.KAPTCHA_BACKGROUND_CLR_FROM, "white");
        initParameters.put(Constants.KAPTCHA_BACKGROUND_CLR_TO, "white");
        initParameters.put(Constants.KAPTCHA_SESSION_KEY, "kaptchaCode");
        initParameters.put(Constants.KAPTCHA_SESSION_DATE, "300");
        bean.setInitParameters(initParameters);
        return bean;
    }
	
	@Bean
	public Producer captchaProducer() {
	    Properties properties = new Properties();
	    // Set kaptcha properties here
	    Config config = new Config(properties);
	    DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
	    defaultKaptcha.setConfig(config);
	    return defaultKaptcha;
	}
}
