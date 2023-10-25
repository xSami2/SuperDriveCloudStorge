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
    private final EncryptionService encryptionService;


    public Boolean isCredentialExist(Integer credentialid , Integer userId){return credentialsMapper.credentialid(credentialid , userId) != 0;}


    public List<CredentialModel> getUserCredentia(Integer currentUserId){
        return credentialsMapper.getUserCredentialByUserId(currentUserId);
    }



    public void createCredential(CredentialModel credentialModel){

        boolean  isCredentialExistInDatabase = isCredentialExist(credentialModel.getCredentialid(),userService.getUserId());
        System.out.println(isCredentialExistInDatabase);
        if(isCredentialExistInDatabase){
            System.out.println(credentialModel);
            String encryptedPassword = encryptionService.encryptValue(credentialModel.getPassword() , credentialModel.getKey());
            credentialModel.setEncryptedPassword(encryptedPassword);
            System.out.println(credentialModel);
            credentialModel.setUserid(userService.getUserId());
            System.out.println(credentialModel);

            credentialsMapper.update(credentialModel);
        } else {
            credentialModel.setUserid(userService.getUserId());
            credentialModel.setKey(getRandomKey());
            String encryptedPassword = encryptionService.encryptValue(credentialModel.getPassword() , credentialModel.getKey());
            credentialModel.setEncryptedPassword(encryptedPassword);
            credentialsMapper.insert(credentialModel);
        }

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
