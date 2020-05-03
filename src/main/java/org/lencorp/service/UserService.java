package org.lencorp.service;

import lombok.AllArgsConstructor;
import org.lencorp.model.dto.UserDto;
import org.lencorp.model.mapper.UserMapper;
import org.lencorp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserDto getUser(Long id) {
        return userMapper.userToUserDto(userRepository.findUserById(id));
    }
}
