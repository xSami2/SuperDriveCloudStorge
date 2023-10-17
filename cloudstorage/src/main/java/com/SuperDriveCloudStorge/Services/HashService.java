package com.SuperDriveCloudStorge.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;

@Service
public class HashService {

    public final Logger logger = LoggerFactory.getLogger(HashService.class);

    public String getHashedValue(String password, String salt) {
        byte[] hashedValue = null;

        int iterCount = 12288;
        int derivedKeyLength = 256;
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), iterCount, derivedKeyLength * 8);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            hashedValue = factory.generateSecret(spec).getEncoded();
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            logger.error(e.getMessage());
        }

        return Base64.getEncoder().encodeToString(hashedValue);
    }

    public  String generateSalt(int length) {
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
