package com.SuperDriveCloudStorge.Controller;


import com.SuperDriveCloudStorge.Model.CredentialModel;
import com.SuperDriveCloudStorge.Model.NoteModel;
import com.SuperDriveCloudStorge.Services.CredentialService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping({"/credential"})

public class CredentialController {

      private final CredentialService credentialService;
    @PostMapping
    public String createCredentials(CredentialModel credentialModel){
        credentialService.createCredential(credentialModel);
        return "redirect:/home";
    }

}
