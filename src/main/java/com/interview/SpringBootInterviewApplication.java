package com.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan
public class SpringBootInterviewApplication {

	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootInterviewApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootInterviewApplication.class, args);
	}

}
