package com.codeup.springblog;

import model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String posts(Model model){
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("post 1", "post 1 content"));
        posts.add(new Post("post 2", "post 2 content"));
        model.addAttribute("posts", posts);
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable int id, Model model){
        Post post = new Post("title", "content");
        model.addAttribute("post", post);
        return "posts/show";
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
