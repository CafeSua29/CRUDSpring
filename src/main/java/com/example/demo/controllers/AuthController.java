package com.example.demo.controllers;

import com.example.demo.repository.dto.LoginDto;
import com.example.demo.repository.dto.RegisterDto;
import com.example.demo.repository.entity.User;
import com.example.demo.repository.repo.UserRepository;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(Model model) {
        LoginDto loginDto = new LoginDto();

        model.addAttribute(loginDto);

        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        RegisterDto registerDto = new RegisterDto();

        model.addAttribute(registerDto);
        model.addAttribute("success", false);

        return "register";
    }

    @PostMapping("/register")
    public String createUser(Model model, @Valid @ModelAttribute RegisterDto registerDto, BindingResult result){
        if (!registerDto.getPassword().equals(registerDto.getCfPassword())) {
            result.addError(new FieldError("registerDto", "cfPassword",
                    "Password and Confirm Password not match"));
        }

        Optional<User> existUser = userRepository.findByUsername(registerDto.getUsername());

        if (existUser != null) {
            result.addError(new FieldError("registerDto", "username",
                    "Username is already used"));
        }

        if (result.hasErrors())
            return "register";

        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setRole("USER");

        userRepository.save(user);

        model.addAttribute("success", true);

        return "register";
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }
}


