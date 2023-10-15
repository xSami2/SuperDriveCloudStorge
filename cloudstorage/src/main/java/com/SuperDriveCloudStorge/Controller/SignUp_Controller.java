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

    @Autowired
    SignUp_Service signUpService;

    @GetMapping
    public String signupView( @ModelAttribute("User_model") User_Model user) {
        return "signup";
    }


    @PostMapping
    public String CreateUser(@ModelAttribute("User_model") User_Model user){
        signUpService.CreateUser(user);
        return "signup";
    }



}

