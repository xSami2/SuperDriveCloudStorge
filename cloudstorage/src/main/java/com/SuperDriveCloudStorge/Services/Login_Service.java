package com.SuperDriveCloudStorge.Services;

import com.SuperDriveCloudStorge.Mapper.UsersMapper;
import org.springframework.stereotype.Service;

@Service
public class Login_Service {


    private final UsersMapper userMapper;
    private final  HashService hashService;

    public Login_Service(UsersMapper usersMapper, HashService hashService) {
        this.userMapper = usersMapper;
        this.hashService = hashService;
    }


}
