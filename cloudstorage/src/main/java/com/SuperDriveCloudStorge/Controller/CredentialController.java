package com.SuperDriveCloudStorge.Controller;


import com.SuperDriveCloudStorge.Model.CredentialModel;
import com.SuperDriveCloudStorge.Services.CredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("delete/{credentialid}")
    public String deleteCredentials(@PathVariable Integer credentialid){
        credentialService.deleteCredentialById(credentialid);
        return "redirect:/home";
    }


}
