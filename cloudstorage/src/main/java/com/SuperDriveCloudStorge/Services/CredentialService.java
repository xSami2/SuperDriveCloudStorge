package com.SuperDriveCloudStorge.Services;

import com.SuperDriveCloudStorge.Mapper.CredentialsMapper;
import com.SuperDriveCloudStorge.Model.CredentialModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CredentialService {

    private final UserService userService;
    private final CredentialsMapper credentialsMapper;


    public Boolean isCredentialidExist(Integer credentialid , Integer userId){return credentialsMapper.credentialid(credentialid , userId) != 0;}


    public List<CredentialModel> getUserCredentia(Integer currentUserId){
        return credentialsMapper.getUserCredentialByUserId(currentUserId);
    }



    public void createCredential(CredentialModel credentialModel){
        credentialModel.setUserid(userService.getUserId());
        credentialModel.setKey(getRandomKey());
        System.out.println(credentialModel);
        credentialsMapper.insert(credentialModel);
    }

    public void deleteCredentialById(Integer credentialid){
        credentialsMapper.deleteCredentialById(credentialid);
    }


    public String getRandomKey() {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16];
        random.nextBytes(key);
        return Base64.getEncoder().encodeToString(key);
    }
}
