package com.co.mobile_banking.api.accounttype;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface AccountTypeMapper {
    @SelectProvider(type = AccountTypeProvider.class,method = "buildSelectSql")
    List<AccountType> select();
    @InsertProvider(type = AccountTypeProvider.class,method = "buildInsertSql")
    void add(AccountType accountType);
    @SelectProvider(type = AccountTypeProvider.class,method = "buildSearchByIdSql")
    AccountType findById(Integer id);
    @UpdateProvider(type = AccountTypeProvider.class,method = "buildUpdateIdSql")
    void update(AccountType accountType);
    @SelectProvider(type = AccountTypeProvider.class,method = "buildSearchByNameSql")
    List<AccountType> findALlByName(String name);
}






