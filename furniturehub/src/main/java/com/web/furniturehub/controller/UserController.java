package com.web.furniturehub.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.furniturehub.model.User;
import com.web.furniturehub.service.UserRepository;

@Controller
public class UserController {

  @Autowired
  private UserRepository userService;

  @RequestMapping("/")
  public String root(Model model) {
    User user = new User();
    model.addAttribute("user", user);
    return "index";
  }

  @GetMapping("/register")
  public String showRegistrationForm(Model model) {
    // create model object to store form data
    User user = new User();
    user.setUtype("user");
    model.addAttribute("user", user);
    return "register";
  }

  @PostMapping("/register/save")
  public String registration(@Valid @ModelAttribute("user") User userDto,
      BindingResult result,
      Model model) {
    User existingUser = userService.findByEmail(userDto.getEmail());

    if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
      result.rejectValue("email", null,
          "There is already an account registered with the same email");
    }

    if (result.hasErrors()) {
      model.addAttribute("user", userDto);
      return "/register";
    }
    userDto.setUtype("user");
    userService.save(userDto);
    return "redirect:/register?success";
  }
}
