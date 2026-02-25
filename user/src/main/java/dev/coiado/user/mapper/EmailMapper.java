package dev.coiado.user.mapper;

import dev.coiado.user.dto.EmailDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EmailMapper {

    public EmailDTO toDTO(UUID userId, String emailTo, String subject, String body) {
        EmailDTO emailDto = new EmailDTO();
        emailDto.setUserId(userId);
        emailDto.setEmailTo(emailTo);
        emailDto.setSubject(subject);
        emailDto.setBody(body);

        return emailDto;
    }

}
