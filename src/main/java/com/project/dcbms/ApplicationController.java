package com.project.dcbms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/test_type")
    public String goHome(){
        return "Test_Type";
    }
}