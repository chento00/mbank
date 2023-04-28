package com.co.mobile_banking.api.user;

import com.co.mobile_banking.api.user.web.CreateUserDto;
import com.co.mobile_banking.api.user.web.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{
    private final UserMapper userMapper;
    private final UserMapStruct userMapStruct;

    @Override
    public UserDto insertUser(CreateUserDto createUserDto) {
        User user=userMapStruct.createUserDtoUser(createUserDto);
        userMapper.insert(user);
        return userMapStruct.userToUserDTO(user);
    }

    @Override
    public List<UserDto> findAll() {
        return userMapStruct.userToUserListDto(userMapper.findAll());
    }

    @Override
    public UserDto findUserById(Integer id) {
        User user= userMapper.selectById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("User with %d is not found",id)
                )
        );
        return userMapStruct.userToUserDTO(user);
    }

    @Override
    public Integer deleteByUserId(Integer id) {
        Boolean isIdExist=userMapper.exitsById(id);
        System.out.println(isIdExist);
        if(isIdExist){
            userMapper.delete(id);
            return id;
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                String.format("User with %d is not found",id)
        );
    }

    @Override
    public Integer updateIsDeleteById(Integer id, Boolean status) {
        Boolean isIdExits=userMapper.exitsById(id);
        if(isIdExits){
            userMapper.updateIsDelete(id,status);
            System.out.println("Update : "+userMapper.updateIsDeletedTest(id,status));
            return id;
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                String.format("User with %d is not found",id)
        );
    }
}
