package com.SuperDriveCloudStorge.Mapper;

import com.SuperDriveCloudStorge.Model.User_Model;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersMapper {

    @Select("SELECT count(*) from USERS where username = #{username} and password = #{password}")
    int checkUserCredentials(String username, String password);

    @Select("SELECT salt from USERS where username = #{username}")
    String getUserSalt(String username);

    @Insert(
            "INSERT INTO USERS (username, salt, password, firstname, lastname) " +
                    "VALUES(#{username}, #{salt}, #{password}, #{firstname}, #{lastname})"
    )
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    void insertUser(User_Model user);

}
