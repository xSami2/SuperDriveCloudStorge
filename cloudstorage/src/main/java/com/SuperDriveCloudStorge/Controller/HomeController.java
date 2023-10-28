package com.SuperDriveCloudStorge.Controller;

import com.SuperDriveCloudStorge.Model.CredentialModel;
import com.SuperDriveCloudStorge.Model.FileModel;
import com.SuperDriveCloudStorge.Model.NoteModel;
import com.SuperDriveCloudStorge.Model.UserModel;
import com.SuperDriveCloudStorge.Services.CredentialService;
import com.SuperDriveCloudStorge.Services.FileService;
import com.SuperDriveCloudStorge.Services.NoteService;
import com.SuperDriveCloudStorge.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

     private final FileService fileService;
     private final NoteService noteService;
     private final UserService userService;
     private final CredentialService credentialService;


    @GetMapping
    public String signupView(Model model) {
        Integer currentUserId = userService.getUserId();

        List<CredentialModel> userCredentials =  credentialService.getUserCredentia(currentUserId);
        List<FileModel> userFiles = fileService.getUserFile(currentUserId);
        List<NoteModel> userNotes = noteService.getUserNote(currentUserId);

        model.addAttribute("files" ,userFiles);
        model.addAttribute("notes" ,userNotes);
        model.addAttribute("credentials" ,userCredentials);

        return "home";
    }












}

