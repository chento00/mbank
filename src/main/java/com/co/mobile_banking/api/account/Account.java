package com.co.mobile_banking.api.account;

import com.co.mobile_banking.api.accounttype.AccountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
@NoArgsConstructor
@Setter
@Getter
public class Account {
    private Integer id;
    private String account_no;
    private String account_name;
    private String profile;
    private Integer pin;
    private String password;
    private String phone_number;
    private Integer transfer_limit;
    private List<AccountType> account_type;
}
