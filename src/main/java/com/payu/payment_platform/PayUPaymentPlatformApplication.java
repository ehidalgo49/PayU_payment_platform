package com.payu.payment_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableConfigurationProperties
@ConfigurationPropertiesScan
@EntityScan("com.payu.payment_platform.core.model")
@EnableJpaRepositories("com.payu.payment_platform.infrastructure.adapter.repository")
public class PayUPaymentPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayUPaymentPlatformApplication.class, args);
	}

}
