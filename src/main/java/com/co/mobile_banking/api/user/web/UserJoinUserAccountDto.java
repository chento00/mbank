package com.co.mobile_banking.api.user.web;

import com.co.mobile_banking.api.account.Account;
import com.co.mobile_banking.api.user.User;
import com.co.mobile_banking.api.useraccounts.UserAccount;
import lombok.Builder;

import java.util.List;

public record UserJoinUserAccountDto(
        String name,
        String gender,
        String studentCardId,
        Boolean isStudent,
        List<Account> accountList
) {
}
