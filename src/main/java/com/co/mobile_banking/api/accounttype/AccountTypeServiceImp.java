package com.co.mobile_banking.api.accounttype;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountTypeServiceImp implements AccountTypeService{
    private final AccountTypeMapper accountTypeMapper;
    private final AccountTypeMapStruct accountTypeMapStruct;
    public AccountTypeServiceImp(AccountTypeMapper accountTypeMapper, AccountTypeMapStruct accountTypeMapStruct) {
        this.accountTypeMapper = accountTypeMapper;
        this.accountTypeMapStruct = accountTypeMapStruct;
    }

    @Override
    public List<AccountTypeDto> findAll() {
        List<AccountType> accountTypes=accountTypeMapper.select();
        return accountTypeMapStruct.toDtoList(accountTypes);
    }

    @Override
    public void add(AccountTypeDto accountTypeDto) {
        accountTypeMapper.add(accountTypeMapStruct.toPojo(accountTypeDto));
    }

    @Override
    public AccountTypeDto findById(Integer id) {
        return accountTypeMapStruct.toDto(accountTypeMapper.findById(id));
    }

    @Override
    public void update(AccountTypeDto accountTypeDto) {
        accountTypeMapper.update(accountTypeMapStruct.toPojo(accountTypeDto));
    }

    @Override
    public List<AccountTypeDto> findAllByName(String name) {
        List<AccountType> accountTypes=accountTypeMapper.findALlByName(name);
        return accountTypeMapStruct.toDtoList(accountTypes);
    }
}
