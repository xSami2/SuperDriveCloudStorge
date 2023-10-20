package com.SuperDriveCloudStorge.Mapper;

import com.SuperDriveCloudStorge.Model.UserModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersMapper {

    @Select("SELECT * from USERS where username = #{username}")
    UserModel getUser(String username);

    @Select("SELECT  userId from USERS where username = #{username}")
    int getUserId(String username);


    @Insert(
            "INSERT INTO USERS (username, salt, password, firstname, lastname) " +
                    "VALUES(#{username}, #{salt}, #{password}, #{firstname}, #{lastname})"
    )
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(UserModel user);



}
