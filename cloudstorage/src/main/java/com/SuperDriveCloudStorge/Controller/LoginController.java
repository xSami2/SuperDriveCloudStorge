package com.SuperDriveCloudStorge.Controller;


import com.SuperDriveCloudStorge.Model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {



    @GetMapping
    public String loginView(@ModelAttribute("User_model") UserModel userModel , Model model) {

        return "login";
    }





}
