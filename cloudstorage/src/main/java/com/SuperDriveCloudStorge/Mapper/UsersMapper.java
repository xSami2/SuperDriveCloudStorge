package com.SuperDriveCloudStorge.Mapper;

import com.SuperDriveCloudStorge.Model.User_Model;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface UsersMapper {


    @Insert(
            "INSERT INTO USERS (username, salt, password, firstname, lastname) " +
                    "VALUES(#{username}, #{salt}, #{password}, #{firstName}, #{lastName})"
    )
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int inertUser(User_Model user);

}
