package dev.coiado.user.domain;

import dev.coiado.user.enums.UserRoles;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_users")
public class UserModel {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID user_id;
    private String username;
    private String email;
    private String password;
    private boolean account_locked;
    private UserRoles userRole;
    private boolean email_verified;
}
