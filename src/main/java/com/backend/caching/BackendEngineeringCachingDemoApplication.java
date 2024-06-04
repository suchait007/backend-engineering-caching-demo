package com.backend.caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
public class BackendEngineeringCachingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendEngineeringCachingDemoApplication.class, args);
	}

}
