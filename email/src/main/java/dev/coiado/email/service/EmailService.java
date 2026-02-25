package dev.coiado.email.service;

import dev.coiado.email.domain.EmailModel;
import dev.coiado.email.enums.EmailStatus;
import dev.coiado.email.repositorie.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final EmailRepository emailRepository;

    @Value("${spring.mail.username}")
    private String emailFrom;

    public EmailService(JavaMailSender mailSender,
                        EmailRepository emailRepository) {
        this.mailSender = mailSender;
        this.emailRepository = emailRepository;
    }

    @Transactional
    public void sendEmail(EmailModel emailModel){

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailFrom);
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getBody());

            mailSender.send(message);

            emailModel.setStatus(EmailStatus.SENT);
            emailModel.setSendDate(LocalDateTime.now());

        } catch (Exception ex) {
            emailModel.setStatus(EmailStatus.FAILED);
            System.out.println("Error sending email: " + ex.getMessage());
        }

        emailRepository.save(emailModel);
    }
}
