package com.co.mobile_banking.api.user;
import com.co.mobile_banking.api.user.web.CreateUserDto;
import com.co.mobile_banking.api.user.web.UserDto;
import java.util.List;
public interface UserService {
    UserDto insertUser(CreateUserDto createUserDto);
    List<UserDto> findAll();
    UserDto findUserById(Integer id);
    Integer deleteByUserId(Integer id);
    Integer updateIsDeleteById(Integer id,Boolean status);
}
