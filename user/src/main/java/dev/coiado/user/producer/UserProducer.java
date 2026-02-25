package dev.coiado.user.producer;

import dev.coiado.user.domain.UserModel;
import dev.coiado.user.dto.EmailDTO;
import dev.coiado.user.mapper.EmailMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {

    private final RabbitTemplate rabbitTemplate;
    private final EmailMapper emailMapper;

    private final String routingKey = "email-queue";

    public UserProducer(RabbitTemplate rabbitTemplate, EmailMapper emailMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.emailMapper = emailMapper;
    }

    public void publishEvent(UserModel userModel) {

        EmailDTO email = emailMapper.toDTO(
                userModel.getId(),
                userModel.getEmail(),
                "Welcome to System",
                "Hello " + userModel.getUsername() + ",\n\nWelcome to System! We are excited to have you on board.\n\nBest regards,\nSystem Team"
        );

        rabbitTemplate.convertAndSend("", routingKey, email);
    }

}
