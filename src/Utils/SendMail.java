package Utils;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;


public class SendMail {
	private static SendMail instance = new SendMail();
	private SendMail(){}
	public static SendMail getInstance(){
		return instance;
	}
	
	public boolean sendVerificationLink(String verification_link, String to){
		//String to="amitashukla02@gmail.com";
		
		String from="amitashukla0906@gmail.com";
		String host = "smtp.gmail.com";
		 final String username = "amitashukla0906@gmail.com";
		 final String password = "asit,s9!";
		//Properties properties = System.getProperties();
		//properties.setProperty("mail.smtp.host", host);
		 
		 Properties prop = new Properties();
		 prop.put("mail.smtp.auth","true");
		 prop.put("mail.smtp.starttls.enable","true");
		 prop.put("mail.smtp.host", host);
		 prop.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(prop, new javax.mail.Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(username, password);
			}
		});
		
		MimeMessage message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Test mail form JavaMail");
			message.setText("This is an autogenerated email by amita shukla\nPlease confirm your account.\n"+verification_link);
			
			Transport.send(message);
			//System.out.println("Email sent successfully...");
			return true;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
}
