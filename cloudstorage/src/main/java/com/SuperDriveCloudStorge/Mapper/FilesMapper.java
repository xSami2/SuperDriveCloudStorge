package com.SuperDriveCloudStorge.Mapper;

import com.SuperDriveCloudStorge.Model.FileModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper

public interface FilesMapper {

    @Insert(
            "INSERT INTO FILES (filename, contenttype, filesize, userid, filedata) " +
                    "VALUES (#{filename}, #{contenttype}, #{filesize}, #{userid}, #{filedata})"
    )
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    void insert(FileModel file);
}
