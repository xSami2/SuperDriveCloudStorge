package com.SuperDriveCloudStorge.Controller;

import com.SuperDriveCloudStorge.Model.User_Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUp_Controller {



    @GetMapping
    public String signupView( @ModelAttribute("User_model") User_Model user) {
        return "signup";
    }

    public void CreateUser(Model model){

    }



}

