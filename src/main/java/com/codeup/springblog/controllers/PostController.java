package com.codeup.springblog.controllers;

import com.codeup.springblog.model.Post;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.model.User;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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
    @GetMapping("/posts/{id}/edit")
    public String editPostForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getPostById(id));
        return "posts/edit";
    }
    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }
    @GetMapping(path="/posts/create")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User postUser = userDao.getUserById(1);
        post.setUser(postUser);
        postDao.save(post);
        emailService.prepareAndSend(post, "New Post Created", "A new post was created");
        return "redirect:/posts";
    }
}
