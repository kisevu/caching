package org.ameda.kevin.cachingredis;

import org.ameda.kevin.cachingredis.config.SimpleRedisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SimpleRedisConfig.class})
public class CachingRedisApplication {
	public static void main(String[] args) {
		SpringApplication.run(CachingRedisApplication.class, args);
	}
}
