package com.gt.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

@Service
public class KaptchaService {
	private final Producer captchaProducer;

    @Autowired
    public KaptchaService(Producer captchaProducer) {
        this.captchaProducer = captchaProducer;
    }

    public String generateCaptchaCode(HttpServletRequest request) {
        String captchaCode = captchaProducer.createText();
        request.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, captchaCode);
        return captchaCode;
    }

    public boolean validateCaptchaCode(HttpServletRequest request, String userCaptchaCode) {
        String captchaCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (captchaCode == null || !captchaCode.equals(userCaptchaCode)) {
            return false;
        }
        request.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        return true;
    }
}
