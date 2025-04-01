package com.olms.olms.util;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Properties;


/**
 * The type Email utility.
 */
public class EmailUtility {
    /**
     * Send email.
     *
     * @param host      the host
     * @param port      the port
     * @param userName  the user name
     * @param password  the password
     * @param toAddress the to address
     * @param subject   the subject
     * @param message   the message
     * @throws MessagingException the messaging exception
     */
    public static void sendEmail(String host, String port, final String userName, final String password, String toAddress, String subject, String message) throws MessagingException {

		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			@Contract(value = " -> new", pure = true)
			@Override
			public @NotNull PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		msg.setText(message);
		// sends the e-mail
		Transport.send(msg);
	}
}