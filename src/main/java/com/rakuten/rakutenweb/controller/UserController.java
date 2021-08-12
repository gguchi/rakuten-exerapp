package com.rakuten.rakutenweb.controller;

import com.rakuten.rakutenweb.model.User;
import com.rakuten.rakutenweb.service.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @InitBinder
    public void iniBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @Autowired
    private UserServices userServices;

    @GetMapping("/userRegister")
    public String userRegister(Model model){
        User user = new User();
        model.addAttribute("username", user);
        return "register";
    }

    @GetMapping("/userLogin")
    public String userLogin(Model model){
        User user = new User();
        model.addAttribute("username", user);
        return "login";
    }

    @PostMapping("/saveUser")
<<<<<<< HEAD
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/userLogin";
        }
        log.info(">> USER: {}", user.toString());
=======
    public String saveUser(@ModelAttribute("username") User user){
>>>>>>> 9cb1f7aaf7d9086dfb1ee804ce0d11c2d6632ae8
        userServices.save(user);
        return "redirect:/userLogin";
    }


}
