package com.fiuni.sd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ImportResource({"classpath:xmemcached.xml", "classpath:springSecurity.xml"})
@EnableWebSecurity
public class OrderManagementSystemApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementSystemApplication.class, args);
	}
}
