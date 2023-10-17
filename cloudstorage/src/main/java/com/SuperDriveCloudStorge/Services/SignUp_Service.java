package com.SuperDriveCloudStorge.Services;

import com.SuperDriveCloudStorge.Mapper.UsersMapper;
import com.SuperDriveCloudStorge.Model.User_Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SignUp_Service  {

    private final UsersMapper usersMapper;
    private final  HashService hashService;


    public SignUp_Service(UsersMapper usersMapper, HashService hashService) {
        this.usersMapper = usersMapper;
        this.hashService = hashService;
    }

    public void CreateUser(User_Model user){
        String userSalt = hashService.generateSalt(7);
        String hashedPassword = hashService.getHashedValue(user.getPassword() , userSalt);
        user.setSalt(userSalt);
        user.setPassword(hashedPassword);
        usersMapper.insertUser(user);
    }



}
