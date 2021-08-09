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
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @Autowired
    public UserController(UserServices userServices){
        this.userServices = userServices;
    }

    @GetMapping("/userRegister")
    public String userRegister(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @GetMapping("/userLogin")
    public String userLogin(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/userRegister")
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult , RedirectAttributes redirectAttributes){

        if(userServices.userExist(user.getEmail())){
            bindingResult.addError(new FieldError(
                    "user","email","Email address already in use."));
         }
//
//        if(user.getPassword()!=null && user.getPassword() !=null){
//            bindingResult.addError(new FieldError("user","password", "Password did not match"));
//        }

        if(bindingResult.hasErrors()){
            return "register";
        }
        log.info(">> USER: {}", user.toString());
        redirectAttributes.addFlashAttribute("message","Registration Successful");
        userServices.save(user);
        return "redirect:/login";
    }
}
