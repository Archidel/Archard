package com.archidelion.archard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = { "com.archidelion.archard" })
@EntityScan("com.archidelion.archard.bean")
@EnableJpaRepositories(basePackages = "com.archidelion.archard.dao")
@EnableTransactionManagement
public class ArchardApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ArchardApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ArchardApplication.class, args);
	}
}
