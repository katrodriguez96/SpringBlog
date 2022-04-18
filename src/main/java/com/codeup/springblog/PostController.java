package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String posts(){
        return "posts index page";
    }
    @RequestMapping(path="/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String individualPost(@PathVariable int id){
        return "view an individual post with an id of " + id;
    }
    @RequestMapping(path="/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String createPost(){
        return "view the form for creating a post";
    }
    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreatePost(){
        return "create a new post";
    }
}
