package com.tomcat.service.roastgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class RoastGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoastGeneratorApplication.class, args);
	}

}
