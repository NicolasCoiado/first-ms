package dev.coiado.user.controller;

import dev.coiado.user.dto.request.UserRequestDto;
import dev.coiado.user.dto.response.UserResponseDto;
import dev.coiado.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> save (@RequestBody UserRequestDto userData) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userData));
    }



}
