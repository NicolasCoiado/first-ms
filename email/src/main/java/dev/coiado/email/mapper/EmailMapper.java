package dev.coiado.email.mapper;

import dev.coiado.email.domain.EmailModel;
import dev.coiado.email.dto.EmailDTO;
import org.springframework.stereotype.Component;

@Component
public class EmailMapper {
    public EmailModel toModel(EmailDTO dto) {
        EmailModel model = new EmailModel();
        model.setUserId(dto.userId());
        model.setEmailTo(dto.emailTo());
        model.setSubject(dto.subject());
        model.setBody(dto.body());
        return model;
    }

}
