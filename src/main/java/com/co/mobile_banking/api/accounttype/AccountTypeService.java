package com.co.mobile_banking.api.accounttype;
import java.util.List;
public interface AccountTypeService {
    List<AccountTypeDto> findAll();
    void add(AccountTypeDto accountTypeDto);
    AccountTypeDto findById(Integer id);
    void update(AccountTypeDto accountTypeDto);
    List<AccountTypeDto> findAllByName(String name);
}
