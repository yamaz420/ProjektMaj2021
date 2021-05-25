package com.example.projektmaj2021.controller;

import com.example.projektmaj2021.entity.Post;
import com.example.projektmaj2021.entity.User;
import com.example.projektmaj2021.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    //private UserService postService;

    //=============== Start ==================
    @GetMapping("/")
    public String welcome() {
        return "homepage";
    }


    //=============== Sign In ===================
    @GetMapping("/signin")
    public String signIn() {
        return "signin";
    }

    @PostMapping("/authenticate-user")
    public String authUser(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           HttpServletResponse response) {
        User user = userService.findUserByUsername(username);
        if (user != null && userService.authUser(username, password)) {
            Long id = user.getId();
            Cookie cookie = new Cookie("currentUser", id.toString());
            response.addCookie(cookie);
            return "redirect:/profile/" + id;
        }
        return "redirect:/authError"; }

    @GetMapping("/authError")
    public String authError(Model model) {
        model.addAttribute("msg", "Sign In Failed");
        return "signin";
    }

    //================ Sign Up ===============
    @GetMapping("/signup")
    public String signUp(@ModelAttribute("user") User user) {
        return "signup";
    }

    @PostMapping("/save-user")
    public String saveUser(User user,
                           @RequestParam("password") String password,
                           @RequestParam("passwordConfirm") String passwordConfirm) {
        if (password.equals(passwordConfirm)) {
            user.setImg("https://via.placeholder.com/150");
            userService.saveUser(user);
            return "redirect:/success";
        }
        return "redirect:/failed"; }

    @GetMapping("/success")
    public String success(@ModelAttribute("user") User user) {
        return "redirect:/signin";
    }

    @GetMapping("/failed")
    public String failed(@ModelAttribute("user") User user,
                         Model model) {
        model.addAttribute("msg", "Oops something went wrong!");
        return "signup";
    }

    //=============== Profile ====================
    @GetMapping("/profile/{id}")
    public ModelAndView showProfile(@ModelAttribute("post") Post post,
                                    @PathVariable long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("profile");
        User userToShow = userService.findUserById(id);
        mv.addObject(userToShow);
        return mv;
    }

    //=============== Sign Out ====================
    @GetMapping("/signout")
    public String logout(HttpServletResponse response){
        Cookie cookie = new Cookie("currentUserId", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "homepage";
    }

     // ================== EDIT ==================
    @GetMapping("/edit/{id}")
    public ModelAndView updateUser(@PathVariable long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("edit");
        User userToUpdate = userService.findUserById(id);
        mv.addObject(userToUpdate);
        return mv;
    }

    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/profile";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}

    /** @TODO: Lägga till alla Post- och GetMapping = DONE!
     */
