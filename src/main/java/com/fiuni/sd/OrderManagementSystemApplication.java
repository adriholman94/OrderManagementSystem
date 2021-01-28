package com.fiuni.sd;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.fiuni.sd.Beans.User.User;
import com.fiuni.sd.DTO.User.UserDTO;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, SecurityFilterAutoConfiguration.class })
@ImportResource({"classpath:xmemcached.xml"})

public class OrderManagementSystemApplication extends SpringBootServletInitializer{
//implements CommandLineRunner{
  //  @Autowired
    //private JavaMailSender javaMailSender;



	public static void main(String[] args) {
		SpringApplication.run(OrderManagementSystemApplication.class, args);
	}
	

	/*
	 * public void run(String... args) {
	 * 
	 * System.out.println("Sending Email...");
	 * 
	 * sendEmail(); //sendEmailWithAttachment();
	 * 
	 * System.out.println("Done");
	 * 
	 * }
	 * 
	 * void sendEmail() {
	 * 
	 * List<UserDTO> listClients;
	 * 
	 * // b=new UserDTO(); //"zai.fleitas@gmail.com" for (UserDTO c : listClients) {
	 * SimpleMailMessage msg = new SimpleMailMessage(); msg.setTo(c.getUserMail());
	 * 
	 * msg.setSubject("Testing from Spring Boot");
	 * msg.setText("Hello World \n Spring Boot Email");
	 * 
	 * javaMailSender.send(msg); } }
	 */
}
