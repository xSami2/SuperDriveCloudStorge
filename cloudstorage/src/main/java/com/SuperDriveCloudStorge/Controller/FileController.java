package com.SuperDriveCloudStorge.Controller;

import com.SuperDriveCloudStorge.Model.FileModel;
import com.SuperDriveCloudStorge.Services.FileService;
import com.SuperDriveCloudStorge.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
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
    public String uploadFile(@RequestParam("fileUpload") MultipartFile file) throws IOException {
        fileService.uploadFile(file , userService.getUserId());
        return "redirect:/home";
    }

    @GetMapping("/delete/{fileId}")
    public String deleteFileById(@PathVariable Integer fileId){
        fileService.deleteFileById(fileId);
        return "redirect:/home";
    }

    @GetMapping("/view/{fileId}")
    public ResponseEntity<byte[]> viewFile(@PathVariable Integer fileId, RedirectAttributes redirectAttrs) {
        FileModel file = fileService.getFileById(fileId);
        byte[] fileData = file.getFiledata();
        String contentType = file.getContenttype();
        String fileName = file.getFilename(); // Assume the FileModel has a getFileName() method

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(contentType));
        headers.setContentDisposition(ContentDisposition.builder("attachment")
                .filename(fileName)
                .build());

        return new ResponseEntity<>(fileData, headers, HttpStatus.OK);
    }

}
