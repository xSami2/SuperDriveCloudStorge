package com.SuperDriveCloudStorge.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/result")
public class Result_Controller {


    @GetMapping
    public String resultView(){
        return "result";
    }
}
