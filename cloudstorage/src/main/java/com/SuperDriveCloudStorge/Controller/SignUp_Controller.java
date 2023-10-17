package com.SuperDriveCloudStorge.Controller;

import com.SuperDriveCloudStorge.Model.User_Model;
import com.SuperDriveCloudStorge.Services.SignUp_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUp_Controller {

    private final SignUp_Service signUpService;


    public SignUp_Controller(SignUp_Service signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping
    public String signupView( @ModelAttribute("User_model") User_Model userModel) {
        return "signup";
    }


    @PostMapping
    public String createUser(@ModelAttribute("User_model") User_Model userModel){
        signUpService.CreateUser(userModel);
        return "login";
    }



}

