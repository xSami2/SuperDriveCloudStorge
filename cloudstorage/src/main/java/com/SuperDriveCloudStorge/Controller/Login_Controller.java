package com.SuperDriveCloudStorge.Controller;


import com.SuperDriveCloudStorge.Model.User_Model;
import com.SuperDriveCloudStorge.Services.Login_Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class Login_Controller {

     private final Login_Service loginService;

    public Login_Controller(Login_Service loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String loginView( @ModelAttribute("User_model") User_Model userModel) {
        return "login";
    }


    @PostMapping
    public String userLogin(@ModelAttribute("User_model") User_Model userModel){
        boolean isUserValid  = loginService.userAuthentication(userModel);
        return isUserValid ? "home" : "login";
    }


}
