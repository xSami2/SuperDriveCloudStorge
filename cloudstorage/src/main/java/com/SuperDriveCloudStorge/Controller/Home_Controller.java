package com.SuperDriveCloudStorge.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class Home_Controller {


    @GetMapping
    public String signupView() {
        return "home";
    }

}

