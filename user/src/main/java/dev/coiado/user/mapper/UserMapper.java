package dev.coiado.user.mapper;

import dev.coiado.user.domain.UserModel;
import dev.coiado.user.dto.request.UserRequestDto;
import dev.coiado.user.dto.response.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserModel toModel (UserRequestDto request) {
        UserModel user = new UserModel();
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPassword(request.password());
        return user;
    }

    public static UserResponseDto toResponse (UserModel model) {
        return new UserResponseDto(
                model.getId(),
                model.getUsername(),
                model.getEmail(),
                model.isAccount_locked(),
                model.getUserRole(),
                model.isEmail_verified()
        );
    }
}