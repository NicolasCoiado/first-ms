package dev.coiado.user.dto.request;

public record UserRequestDto (
        String username,
        String email,
        String password
){}
