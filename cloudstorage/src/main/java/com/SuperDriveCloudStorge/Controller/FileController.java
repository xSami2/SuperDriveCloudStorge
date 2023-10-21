package com.SuperDriveCloudStorge.Controller;

import com.SuperDriveCloudStorge.Model.FileModel;
import com.SuperDriveCloudStorge.Services.FileService;
import com.SuperDriveCloudStorge.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping({"/file"})
public class FileController {

    private final FileService fileService;
    private final UserService userService;

    @PostMapping()
    public String uploadFile(@RequestParam("fileUpload") MultipartFile file , Model model ) throws IOException {
        Integer currentUserId = userService.getUserId();
        fileService.uploadFile(file , userService.getUserId());
        model.addAttribute("files" ,fileService.getUserFile(currentUserId));
        return "home";
    }

    @GetMapping("/delete/{fileId}")
    public String deleteFileById(@PathVariable Integer fileId ,  RedirectAttributes redirectAttrs){
        System.out.println(fileId);
        fileService.deleteFileById(fileId);
        return "redirect:/home";
    }

    @GetMapping("/view/{fileId}")
    public ResponseEntity<byte[]> viewFile(@PathVariable Integer fileId , RedirectAttributes redirectAttrs) {
        FileModel file = fileService.getFileById(fileId);
        byte[] fileData = file.getFiledata();
        String contentType = file.getContenttype();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(contentType));
        return new ResponseEntity<>(fileData, headers, HttpStatus.OK);
    }
}
