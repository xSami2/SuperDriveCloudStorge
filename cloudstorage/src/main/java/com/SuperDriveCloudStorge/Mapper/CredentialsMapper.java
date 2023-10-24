package com.SuperDriveCloudStorge.Mapper;

import com.SuperDriveCloudStorge.Model.CredentialModel;
import com.SuperDriveCloudStorge.Model.NoteModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CredentialsMapper  {

    @Select("SELECT * FROM CREDENTIALS Where userId = #{userId}")
    List<CredentialModel> getUserCredentialByUserId(Integer userId);

    @Select("SELECT COUNT(*) FROM CREDENTIALS WHERE credentialid = #{credentialid} AND userId = #{userId}")
    int credentialid(Integer credentialid ,  Integer userId);

    @Delete("DELETE FROM CREDENTIALS Where credentialid = #{credentialid}")
    void deleteCredentialById(Integer credentialid);

    @Insert(
            "INSERT INTO CREDENTIALS (url , username  , key , password , userid)" +
                    "VALUES (#{url} , #{username} , #{key}  , #{password} , #{userid})"
    )
    @Options(useGeneratedKeys = true , keyProperty = "credentialid")
    void insert(CredentialModel credentialModel);

}
