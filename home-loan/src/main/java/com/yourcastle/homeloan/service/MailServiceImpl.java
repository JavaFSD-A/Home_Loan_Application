/**
 * @author Anju D
 */

package com.yourcastle.homeloan.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
    JavaMailSender mailSender;
	
	@Override
	public void sendEmail(String email, String message) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		 
        try {
 
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
 
            mimeMessageHelper.setSubject("Loan Status Update");
            mimeMessageHelper.setFrom(new InternetAddress("testisthebest2000@gmail.com", "YourCastle HomeLoan Application"));
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setText(message);
 
            mailSender.send(mimeMessageHelper.getMimeMessage());
 
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
		
}

