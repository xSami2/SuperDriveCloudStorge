package com.SuperDriveCloudStorge.Controller;

import com.SuperDriveCloudStorge.Model.FileModel;
import com.SuperDriveCloudStorge.Model.UserModel;
import com.SuperDriveCloudStorge.Services.FileService;
import com.SuperDriveCloudStorge.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

     private final FileService fileService;
     private final UserService userService;


    @GetMapping
    public String signupView(Model model) {
        Integer currentUserId = userService.getUserId();
        model.addAttribute("files" ,fileService.getUserFile(currentUserId));
        return "home";
    }












}

