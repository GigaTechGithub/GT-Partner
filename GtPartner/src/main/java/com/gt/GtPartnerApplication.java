package com.gt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication//(scanBasePackages={"com.gt.controllers", "com.gt.models", "com.gt.repo", "com.gt.services"})
@CrossOrigin(origins = "*")
public class GtPartnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtPartnerApplication.class, args);
	}

}
