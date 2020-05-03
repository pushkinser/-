package org.lencorp.model.mapper;

import org.lencorp.model.dto.UserDto;
import org.lencorp.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {


    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    List<User> userDtoToUserList(List<UserDto> userDtos);

    List<UserDto> userToUserDtoList(List<User> users);
}
