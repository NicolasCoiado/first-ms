package dev.coiado.user.security;

import lombok.Builder;

@Builder
public record JWTUserData(
        Long id, String name, String email
) {}
