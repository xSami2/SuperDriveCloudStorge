package com.SuperDriveCloudStorge.Services;

import com.SuperDriveCloudStorge.Mapper.UsersMapper;
import com.SuperDriveCloudStorge.Model.User_Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

@Service
public class SignUp_Service  {

    private final UsersMapper usersMapper;
    private final  HashService hashService;

    @Autowired
    public SignUp_Service(UsersMapper usersMapper, HashService hashService) {
        this.usersMapper = usersMapper;
        this.hashService = hashService;
    }

    public void CreateUser(User_Model user){
        String userSalt = generateSalt(7);
        user.setSalt(userSalt);
        String hashedPassword = hashService.getHashedValue(user.getPassword() , user.getSalt());
        user.setPassword(hashedPassword);
        System.out.println(user);
        usersMapper.inertUser(user);
    }


    public static String generateSalt(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // Define the characters that can be part of the gibberish word
        String characters = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
