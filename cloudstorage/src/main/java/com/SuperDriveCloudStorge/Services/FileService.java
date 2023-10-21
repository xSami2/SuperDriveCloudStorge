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



    public boolean isDuplicateFileName(String fileName){return filesMapper.isDuplicateFileName(fileName) == 0;}

      public void uploadFile(@RequestParam("fileUpload") MultipartFile file  , Integer currentUserId) throws IOException {
         boolean isFileNotEmpty  = !file.isEmpty();
         boolean isDuplicateFileName  = isDuplicateFileName(String.valueOf(file.getOriginalFilename()));
          System.out.println(isDuplicateFileName);
          System.out.println(isFileNotEmpty);
         if (isFileNotEmpty && isDuplicateFileName){
             FileModel newFile = new FileModel(null , file.getOriginalFilename() , file.getContentType() , file.getSize() , currentUserId , file.getBytes() );
             filesMapper.insert(newFile);
         }



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
