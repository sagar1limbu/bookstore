package com.bookstore.utility;

import java.util.Locale;

import com.bookstore.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;


@Component
public class MailConstructor {
	@Autowired
	private Environment env;
	
	public SimpleMailMessage constructResetTokenEmail(
			String contextPath, Locale locale, String token, Users user, String password
			) {
		
		String url = contextPath + "/newUser?token="+token;
		String message = "\nPlease click on this link to verify your email and edit your personal information. Your password is: \n"+password;
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setSubject("Le's Bookstore - New User");
		email.setText(url+message);
		email.setFrom(env.getProperty("support.email"));
		return email;
		
	}
}
