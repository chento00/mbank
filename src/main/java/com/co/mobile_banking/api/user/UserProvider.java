package com.co.mobile_banking.api.user;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.jdbc.SQL;

public class UserProvider {
    private final String tblName="users";
    @Result(column = "is_student")
    public String buildInsertSql(@Param("u") User user){
        return new SQL(){{
            INSERT_INTO(tblName);
            VALUES("name","#{u.name}");
            VALUES("gender","#{u.gender}");
            VALUES("one_signal_id","#{u.oneSignalId}");
            VALUES("student_card_id","#{u.studentCardId}");
            VALUES("is_student","#{u.isStudent}");
            VALUES("is_deleted","FALSE");
        }}.toString();
    }
    public String buildSelectSql(){
        return new SQL(){{
            SELECT("*");
            FROM(tblName);
            WHERE("is_deleted=false");
        }}.toString();
    }
    public String buildSelectByIdSql(){
        return new SQL(){{
            SELECT("*");
            FROM(tblName);
            WHERE("id=#{id}","is_deleted=false");
        }}.toString();
    }
    public String buildDeleteById(){
        return new SQL() {{
            DELETE_FROM(tblName);
            WHERE("id=#{id}");
        }}.toString();
    }
    public String buildUpdateIsDeletedById(){
        return new SQL(){{
            UPDATE(tblName);
            SET("is_deleted=#{status}");
            WHERE("id=#{id}");
        }}.toString();
    }
}
