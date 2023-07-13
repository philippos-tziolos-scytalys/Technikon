package com.scytalys.technikon.mapper;

import com.scytalys.technikon.domain.User;
import com.scytalys.technikon.dto.UserDto;
import com.scytalys.technikon.transfer.resource.UserResource;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User, UserResource>{

    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);
}
