package dev.coiado.user.service;

import dev.coiado.user.domain.UserModel;
import dev.coiado.user.dto.request.UserRequestDto;
import dev.coiado.user.dto.response.UserResponseDto;
import dev.coiado.user.enums.UserRoles;
import dev.coiado.user.mapper.UserMapper;
import dev.coiado.user.producer.UserProducer;
import dev.coiado.user.repositorie.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserProducer userProducer;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserProducer userProducer, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserResponseDto save (UserRequestDto userDataRequest) {
        UserModel user = userMapper.toModel(userDataRequest);
        user.setUserRole(UserRoles.REGULAR);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userProducer.publishEvent(user);

        return UserMapper.toResponse(userRepository.save(user));
    }
}
