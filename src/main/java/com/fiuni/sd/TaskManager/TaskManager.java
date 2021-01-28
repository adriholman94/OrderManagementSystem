package com.fiuni.sd.TaskManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fiuni.sd.DTO.User.UserDTO;
import com.fiuni.sd.Service.User.IUserService;

@Component
public class TaskManager {

	@Autowired
    private IUserService userService;
    @Autowired
    private JavaMailSender javaMailSender;
    
	@Scheduled(cron = "${cron.secondPeriod}")
	public void task() {
		for (UserDTO user : userService.getUsers().getUsers()) {
			if(user.getUserMail() != ""){
				SimpleMailMessage email = new SimpleMailMessage();
				email.setTo(user.getUserMail());
				email.setSubject("");
				email.setText("notificado desde la aplicacion");
				javaMailSender.send(email);
				System.out.println("mesaje enviado a "+user.getUserMail());
			}
		}
    }
}
