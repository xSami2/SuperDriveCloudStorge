package com.SuperDriveCloudStorge.Services;

import com.SuperDriveCloudStorge.Mapper.FilesMapper;
import com.SuperDriveCloudStorge.Mapper.UsersMapper;
import com.SuperDriveCloudStorge.Model.FileModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
@RequiredArgsConstructor
public class FileService {

      private final FilesMapper filesMapper;
      private  final UsersMapper usersMapper;

    public void uploadFile(@RequestParam("fileUpload") MultipartFile file ) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentUsername = authentication.getName();
            int currentUserId = usersMapper.getUserId(currentUsername);
            FileModel newFile = new FileModel(null , file.getOriginalFilename() , file.getContentType() , file.getSize() , currentUserId , file.getBytes() );
            System.out.println(newFile);
             filesMapper.insert(newFile);


        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
