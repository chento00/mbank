package com.co.mobile_banking.api.user.web;

import com.co.mobile_banking.api.user.UserService;
import com.co.mobile_banking.base.BaseRest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Slf4j
public class UserRestController {
    private final UserService userService;

    @PostMapping
    BaseRest<?> insert(@RequestBody @Valid CreateUserDto createUserDto) {
        UserDto userDto = userService.insertUser(createUserDto);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been add success")
                .timestamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }

    @GetMapping
    BaseRest<?> findAll() {
        List<UserDto> userDtoList=userService.findAll();
        return BaseRest.builder()
                .status(true)
                .message("List all Student")
                .code(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .data(userService.findAll())
                .build();
    }

    @GetMapping("/{id}")
    BaseRest<?> findById(@PathVariable("id") Integer id) {
        UserDto userDto = userService.findUserById(id);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .message("User has been found")
                .data(userDto)
                .build();
    }

    @DeleteMapping("/{id}")
    BaseRest<?> deleteById(@PathVariable("id") Integer id) {
        Integer deletedId = userService.deleteByUserId(id);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .message("User has been delete successfully")
                .data(deletedId)
                .build();
    }
    @PutMapping("/{id}")
    BaseRest<?> updateIsDeletedById(@PathVariable("id")Integer id,@RequestBody IsDeletedDto isDeleted){
        Integer deletedId=userService.updateIsDeleteById(id,isDeleted.status());
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .message("User has been deleted successfully")
                .data(deletedId)
                .build();
    }
}
