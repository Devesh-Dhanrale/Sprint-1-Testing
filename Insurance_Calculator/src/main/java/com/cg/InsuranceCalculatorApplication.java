package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class InsuranceCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceCalculatorApplication.class, args);
	}
	
	@Configuration
    class RestTemplateConfig {
            
            @Bean
//            @LoadBalanced
            public RestTemplate restTemplate() {
              return new RestTemplate();
            }
    }

}
