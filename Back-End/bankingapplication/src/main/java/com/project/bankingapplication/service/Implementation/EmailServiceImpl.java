

package com.project.bankingapplication.service.Implementation;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.project.bankingapplication.entity.Customer;

@Service
public class EmailServiceImpl {

	Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
	
	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private JavaMailSender javaMailSender;



	public String sendMail(Customer u) throws MessagingException {
		logger.debug("Debug Occured");
		Context context = new Context();
		context.setVariable("Customer", u);

		String process = templateEngine.process("/home", context);
		javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		helper.setSubject("Welcome " + u.getFirstName());
		helper.setText(process, true);
		helper.setTo(u.getEmail());
		javaMailSender.send(mimeMessage);
		return "Sent";
	}

}
