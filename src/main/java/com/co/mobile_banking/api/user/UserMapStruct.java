package com.co.mobile_banking.api.user;

import com.co.mobile_banking.api.user.web.CreateUserDto;
import com.co.mobile_banking.api.user.web.UserDto;
import lombok.Builder;
import org.mapstruct.Mapper;
import java.util.List;
@Mapper(componentModel = "spring")
public interface UserMapStruct {
    User createUserDtoUser(CreateUserDto createUserDto);
    UserDto userToUserDTO(User user);
    List<UserDto> userToUserListDto(List<User> userList);
    User userDtoToUser(UserDto userDto);
}
