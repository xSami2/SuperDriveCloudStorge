package com.SuperDriveCloudStorge.Mapper;

import com.SuperDriveCloudStorge.Model.CredentialModel;
import com.SuperDriveCloudStorge.Model.NoteModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CredentialsMapper  {

    @Select("SELECT * FROM CREDENTIALS Where userId = #{userId}")
    List<CredentialModel> getUserCredentialByUserId(Integer userId);

    @Insert(
            "INSERT INTO NOTES (url , username  , key , password , userid)" +
                    "VALUES (#{url} , #{username} , #{key}  , #{password} , #{userid})"
    )
    @Options(useGeneratedKeys = true , keyProperty = "credentialid")
    void insert(CredentialModel credentialModel);

}
