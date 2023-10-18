package com.SuperDriveCloudStorge.Controller;

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
@RequestMapping("/home")
public class Home_Controller {


    @GetMapping
    public String signupView() {
        return "home";
    }

    @PostMapping()
    public String uploadFile(@RequestParam("fileUpload") MultipartFile file) {
        try {
            // Process the file
            byte[] bytes = file.getBytes();
            Path path = Paths.get("C:\\Users\\Saami\\IdeaProjects\\SuperDriveCloudStorge\\cloudstorage\\src\\main\\resources\\uploadedFiles\\" + file.getOriginalFilename());
            Files.write(path, bytes);
            // Save the file (omitted for brevity)
            return "home";
        } catch (Exception e) {
            return "home";
        }
    }

}

