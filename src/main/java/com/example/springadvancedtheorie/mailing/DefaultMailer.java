package com.example.springadvancedtheorie.mailing;

import com.example.springadvancedtheorie.domain.Lid;
import com.example.springadvancedtheorie.exceptions.KanMailNietVersturenException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;

@Component
public class DefaultMailer implements Mailer {
    private final JavaMailSender sender;
    @Value("${spring.mail.username}")
    private String username;

    public DefaultMailer(JavaMailSender sender) {
        this.sender = sender;
    }

    @Async
    @Override
    public void bevestigingsMail(Lid lid, String ledenUrl) {
        try{
            var message = sender.createMimeMessage();
            var helper = new MimeMessageHelper(message);
            helper.setFrom(new InternetAddress(username, "Prince"));
            helper.setTo(lid.getEmailadres());
            helper.setSubject("Registratie bevestiging");
            helper.setText("<h1>Goed ingeschreven</h1>", true);

            sender.send(message);
        } catch (MailException | UnsupportedEncodingException | MessagingException e) {
            throw new KanMailNietVersturenException(e);
        }


    }
}
