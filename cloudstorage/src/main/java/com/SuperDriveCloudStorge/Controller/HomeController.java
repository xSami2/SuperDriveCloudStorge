package com.SuperDriveCloudStorge.Controller;

import com.SuperDriveCloudStorge.Services.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

     private final FileService fileService;
    @GetMapping
    public String signupView() {
        return "home";
    }

    @PostMapping()
    public String uploadFile(@RequestParam("fileUpload") MultipartFile file ) {
        fileService.uploadFile(file);
        return "home";
    }

}

