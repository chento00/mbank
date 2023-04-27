package com.co.mobile_banking.api.accounttype;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class AccountTypeProvider {
    private final String tblName="account_types";
    public String buildSelectSql(){
        return new SQL(){{
            //TODO:
            SELECT("*");
            FROM(tblName);
        }}.toString();
    }
    public String buildInsertSql(){
        return new SQL(){{
            INSERT_INTO(tblName);
            VALUES("name", "#{name}");
        }}.toString();
    }
    public String buildSearchByIdSql(){
        return new SQL(){{
            SELECT("*");
            FROM(tblName);
            WHERE("id=#{id}");
        }}.toString();
    }
    public String buildUpdateIdSql(){
        return new SQL(){{
            UPDATE(tblName);
            SET("name=#{name}");
            WHERE("id=#{id}");
        }}.toString();
    }
    public String buildSearchByNameSql(){
        return new SQL(){{
            SELECT("*");
            FROM(tblName);
            WHERE("name LIKE '%' || #{name} || '%'");
            ORDER_BY("id ASC");
        }}.toString();
    }

}
