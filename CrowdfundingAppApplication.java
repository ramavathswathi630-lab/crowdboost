package com.snist.crowdfunding_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrowdfundingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrowdfundingAppApplication.class, args);
		System.out.println("backend is running on PORT:8080,Open URL: http://localhost:8080\n");
	}

}
