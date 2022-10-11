package com.web.furniturehub.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.furniturehub.model.User;
import com.web.furniturehub.service.UserRepository;

@Controller
class LoginController {
    @Autowired
    private UserRepository userService;

    @PostMapping("login")
    String simpleLogin(@Valid @ModelAttribute("user") User userDto,
            BindingResult result,
            Model model) {
                User user = userService.findByEmail(userDto.getEmail());
                if(user == null){
                    return "user not found"; ///####
                }else if (user.getPassword() != userDto.getPassword()){
                    return "invalide password"; 
                }else{
                    if(user.getUtype() == "admin"){
                        return "admin";
                    }
                }
        return "login";
    }
}