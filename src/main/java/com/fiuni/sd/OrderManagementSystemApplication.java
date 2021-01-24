package com.fiuni.sd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, SecurityFilterAutoConfiguration.class })
@ImportResource({"classpath:xmemcached.xml", "classpath:springSecurity.xml"})
public class OrderManagementSystemApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementSystemApplication.class, args);
	}
}
