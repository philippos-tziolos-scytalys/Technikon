package com.scytalys.technikon.mapper;

import com.scytalys.technikon.domain.Repair;
import com.scytalys.technikon.domain.User;
import com.scytalys.technikon.dto.RepairDto;
import com.scytalys.technikon.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper{

    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

    List<User> userDtoListToUserList(List<UserDto> userDtoList);

    List<UserDto> userListToUserDtoList(List<User> userList);
}
