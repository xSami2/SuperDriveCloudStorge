package com.SuperDriveCloudStorge.Services;

import com.SuperDriveCloudStorge.Mapper.FilesMapper;
import com.SuperDriveCloudStorge.Model.FileModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class FileService {

      private final FilesMapper filesMapper;



    public void uploadFile(@RequestParam("fileUpload") MultipartFile file  , Integer currentUserId) throws IOException {
         boolean isFileEmpty = file.isEmpty();
         if (!isFileEmpty){
             FileModel newFile = new FileModel(null , file.getOriginalFilename() , file.getContentType() , file.getSize() , currentUserId , file.getBytes() );
             filesMapper.insert(newFile);
         }
        System.out.println(isFileEmpty);


    }

    public FileModel getFileById(Integer fileId){
       return filesMapper.getFileById(fileId);
    }
    public void deleteFileById(Integer fileId){
        filesMapper.deleteFileById(fileId);
    }

    public List<FileModel> getUserFile(Integer currentUserId){
        return filesMapper.getUserFileByUserId(currentUserId);
    }


}
