package org.ameda.kevin.cachingredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CachingCaffeineApplication {
	public static void main(String[] args) {
		SpringApplication.run(CachingCaffeineApplication.class, args);
	}
}
