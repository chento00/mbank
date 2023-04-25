package com.co.mobile_banking.api.accounttype;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class AccountType {
    private Integer id;
    private String name;
}
