package org.lencorp.controller;

import lombok.AllArgsConstructor;
import org.lencorp.model.dto.UserDto;
import org.lencorp.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("profile/")
    public UserDto getProfile() {
        return userService.getUser(1L);
    }
}
