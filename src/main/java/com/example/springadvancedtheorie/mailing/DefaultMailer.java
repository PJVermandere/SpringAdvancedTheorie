package com.example.springadvancedtheorie.mailing;

import com.example.springadvancedtheorie.domain.Lid;
import com.example.springadvancedtheorie.exceptions.KanMailNietVersturenException;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class DefaultMailer implements Mailer {
    private final JavaMailSender sender;

    public DefaultMailer(JavaMailSender sender) {
        this.sender = sender;
    }

    @Override
    public void bevestigingsMail(Lid lid, String ledenUrl) {
        try{
            var message = new SimpleMailMessage();
            message.setTo(lid.getEmail());
            message.setSubject("Registratie bevestiging");
            message.setText("Goed ingeschreven");
            sender.send(message);
        } catch (MailException e) {
            throw new KanMailNietVersturenException(e);
        }


    }
}
