package com.SuperDriveCloudStorge.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpController {


    @GetMapping
    public String signupView() {
        return "signup";
    }

}
