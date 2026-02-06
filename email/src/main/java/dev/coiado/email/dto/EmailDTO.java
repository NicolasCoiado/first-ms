package dev.coiado.email.dto;

import dev.coiado.email.enums.EmailStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record EmailDTO(
    UUID email_id,
    String subject,
    String body
) {}
