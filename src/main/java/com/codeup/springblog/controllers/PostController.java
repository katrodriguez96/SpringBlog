package com.codeup.springblog.controllers;

import com.codeup.springblog.model.Post;
import com.codeup.springblog.model.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String posts(Model model){
        model.addAttribute("allPosts", postDao.findAll());
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.getPostById(id));
        return "posts/show";
    }
    @GetMapping(path="/posts/create")
    public String createPostForm(){
        return "posts/create";
    }
    @PostMapping("/posts/create")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        postDao.save(new Post(title, body));
        return "redirect:/posts";
    }
}
