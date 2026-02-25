package dev.coiado.email.consumer;

import dev.coiado.email.domain.EmailModel;
import dev.coiado.email.dto.EmailDTO;
import dev.coiado.email.mapper.EmailMapper;
import dev.coiado.email.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import tools.jackson.databind.util.BeanUtil;

@Component
public class EmailConsumer {

    private final EmailService emailService;
    private final EmailMapper emailMapper;

    public EmailConsumer(EmailService emailService, EmailMapper emailMapper) {
        this.emailService = emailService;
        this.emailMapper = emailMapper;
    }

    @RabbitListener(queues = "email-queue")
    public void ListenEmailQueue (@Payload EmailDTO emailDTO){
        EmailModel emailModel = emailMapper.toModel(emailDTO);
        emailService.sendEmail(emailModel);
    }
}
