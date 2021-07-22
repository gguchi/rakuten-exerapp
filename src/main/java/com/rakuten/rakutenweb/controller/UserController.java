package com.rakuten.rakutenweb.controller;

import com.rakuten.rakutenweb.model.Product;
import com.rakuten.rakutenweb.model.User;
import com.rakuten.rakutenweb.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/userRegister")
    public String userRegister(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }
}
