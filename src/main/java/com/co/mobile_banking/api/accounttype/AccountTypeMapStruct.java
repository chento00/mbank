package com.co.mobile_banking.api.accounttype;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper(componentModel = "spring")
public interface AccountTypeMapStruct {
    List<AccountTypeDto> toDtoList(List<AccountType> model);
    AccountTypeDto toDto(AccountType model);
    AccountType toPojo(AccountTypeDto accountTypeDto);
    List<AccountType> toPojoList(List<AccountTypeDto> accountTypeDtos);
}
