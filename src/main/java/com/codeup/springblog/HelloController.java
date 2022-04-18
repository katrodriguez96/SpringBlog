package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello";
    }

    @RequestMapping(path="/hello/{name}/and/{age}", method = RequestMethod.GET)
    @ResponseBody
    public String helloNameAge(@PathVariable String name, @PathVariable int age){
        return "Your name is " + name + " and your age is " + age + ".";
    }
}
