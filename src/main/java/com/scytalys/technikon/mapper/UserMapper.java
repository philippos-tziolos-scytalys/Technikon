package com.scytalys.technikon.mapper;

import com.scytalys.technikon.domain.User;
import com.scytalys.technikon.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper{

    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);
}
