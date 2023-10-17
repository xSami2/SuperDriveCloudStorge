package com.SuperDriveCloudStorge.Services;

import com.SuperDriveCloudStorge.Mapper.UsersMapper;
import com.SuperDriveCloudStorge.Model.User_Model;
import org.springframework.stereotype.Service;

@Service
public class Login_Service {


    private final UsersMapper userMapper;
    private final  HashService hashService;

    public Login_Service(UsersMapper usersMapper, HashService hashService) {
        this.userMapper = usersMapper;
        this.hashService = hashService;
    }

    public boolean userAuthentication(User_Model userModel){
        String userSalt = userMapper.getUserSalt(userModel.getUsername());
        String hashedPassword = hashService.getHashedValue(userModel.getPassword() , userSalt);
        int userAuthenticated = userMapper.checkUserCredentials(userModel.getUsername(), hashedPassword);
        return userAuthenticated == 1;
    }
}
