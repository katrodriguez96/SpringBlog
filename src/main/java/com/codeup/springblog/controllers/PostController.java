package com.codeup.springblog.controllers;

import com.codeup.springblog.model.Post;
import com.codeup.springblog.model.PostRepository;
import com.codeup.springblog.model.User;
import com.codeup.springblog.model.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("allPosts", postDao.findAll());
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getPostById(id));
        return "posts/show";
    }
    @GetMapping(path="/posts/create")
    public String createPostForm() {
        return "posts/create";
    }
    @PostMapping("/posts/create")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        User postUser = userDao.getUserById(1);
        postDao.save(new Post(title, body, postUser));
        return "redirect:/posts";
    }
}
