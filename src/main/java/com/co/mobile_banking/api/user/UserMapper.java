package com.co.mobile_banking.api.user;


import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface UserMapper {
    @InsertProvider(type = UserProvider.class,method = "buildInsertSql")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")// get id
    void insert(@Param("u") User user);

    @Result(column = "student_card_id",property = "studentCardId")
    @Result(column = "is_student",property = "isStudent")
    @SelectProvider(type = UserProvider.class,method = "buildSelectSql")
    List<User> findAll();

    @Result(column = "student_card_id",property = "studentCardId")
    @Result(column = "is_student",property = "isStudent")
    @SelectProvider(type = UserProvider.class,method = "buildSelectByIdSql")
    Optional<User> selectById(@Param("id") Integer id);

    @Select("""
            SELECT EXISTS (SELECT * FROM users WHERE id=#{id})
            """)
    Boolean exitsById(@Param("id") Integer id);

    @DeleteProvider(type = UserProvider.class,method = "buildDeleteById")
    void delete(@Param("id") Integer id);

    @UpdateProvider(type = UserProvider.class,method = "buildUpdateIsDeletedById")
    void updateIsDelete(@Param("id")Integer id,@Param("status") Boolean status);
}
