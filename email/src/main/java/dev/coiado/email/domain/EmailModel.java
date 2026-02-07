package dev.coiado.email.domain;

import dev.coiado.email.enums.EmailStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_email")
@AllArgsConstructor
@NoArgsConstructor
public class EmailModel {

    private final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID user_id;
    private String email_from;
    private String email_to;
    private String subject;
    @Column(columnDefinition = "BODY")
    private String body;
    private LocalDateTime send_date;
    private EmailStatus status;
}
