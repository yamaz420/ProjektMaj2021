package com.example.projektmaj2021.controller;

import com.example.projektmaj2021.entity.Post;
import com.example.projektmaj2021.entity.User;
import com.example.projektmaj2021.service.PostService;
import com.example.projektmaj2021.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    //==========Start==================
    @GetMapping("/posts")
    public String allPosts(@ModelAttribute("post") Post post, Model model,
                           @CookieValue("currentUser") String currentUser) {
        model.addAttribute("posts", postService.getAllPosts());
        model.addAttribute("user", userService.findUserById(Long.parseLong(currentUser)));
        return "posts";
    }

    //================== Add Post ==================
    @PostMapping("/addpost")
    public String savePost(@ModelAttribute Post post, Model model,
                           @CookieValue("currentUser") String currentUser) {
        User curUser = userService.findUserById(Long.parseLong(currentUser));
        model.addAttribute("currentUser", currentUser);
        post.setAuthor(curUser);
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        post.setCreatedDate(timestamp);
        postService.savePost(post);
        return "redirect:/posts";
    }

    //=================Delete Post==================
    @GetMapping("/delete-post/{id}")
    public String deletePost(@PathVariable long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }
}
