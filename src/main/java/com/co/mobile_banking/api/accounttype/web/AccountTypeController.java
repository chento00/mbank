package com.co.mobile_banking.api.accounttype.web;

import com.co.mobile_banking.api.accounttype.AccountTypeDto;
import com.co.mobile_banking.api.accounttype.AccountTypeService;
import com.co.mobile_banking.base.BaseRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account-types")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountTypeController {
    private final AccountTypeService accountTypeService;

    @GetMapping
    public BaseRest<?> findAll(){
        var accountTypeDtoList=accountTypeService.findAll();
        return BaseRest.builder().status(true)
                .code(HttpStatus.OK.value())
                .message("Account type have been found")
                .timestamp(LocalDateTime.now())
                .data(accountTypeDtoList)
                .build();
    }
    @PostMapping
    public BaseRest<?> add(@RequestBody AccountTypeDto accountTypeDto){
        System.out.println(accountTypeDto);
        accountTypeService.add(accountTypeDto);
        return BaseRest.builder().status(true)
                .code(HttpStatus.OK.value())
                .message("Add Success")
                .timestamp(LocalDateTime.now())
                .data(accountTypeDto)
                .build();
    }

    @PutMapping("{id}")
    public BaseRest<?> updateById(@PathVariable("id") Integer id){
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("success")
                .timestamp(LocalDateTime.now())
                .build();
    }
    @GetMapping("/{id}")
    public BaseRest<?> findById(@PathVariable("id") Integer id){
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Search Found")
                .timestamp(LocalDateTime.now())
                .data(accountTypeService.findById(id))
                .build();
    }
    @GetMapping("/{name}")
    public BaseRest<?> findAllByName(@PathVariable("name") String name){
        System.out.println(name);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("search found")
                .timestamp(LocalDateTime.now())
                .data(accountTypeService.findAllByName(name))
                .build();
    }
}
