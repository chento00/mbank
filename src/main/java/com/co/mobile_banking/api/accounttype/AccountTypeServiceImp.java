package com.co.mobile_banking.api.accounttype;

import org.springframework.stereotype.Service;
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
        return accountTypeMapStruct.toDto(accountTypes);
    }
}
