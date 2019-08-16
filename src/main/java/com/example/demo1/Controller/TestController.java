package com.example.demo1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: chensz
 * @CreateTime: 2019-08-15 17:04
 * @Description:
 */
@Controller
public class TestController {

    @RequestMapping("/hello")
    public String fun(){
        return "login";
    }

    @RequestMapping("/success")
    public String fun1(){
        return "success";
    }

    @RequestMapping("/login?error")
    public String fun2(){
        return "error";
    }

}
