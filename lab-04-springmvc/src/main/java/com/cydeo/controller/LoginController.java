package com.cydeo.controller;

import com.cydeo.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login/{email}/{phoneNumber}")
    public String login(@PathVariable String email, @PathVariable String phoneNumber, Model model) {

        model.addAttribute("email", email);
        model.addAttribute("phoneNumber", phoneNumber);
        model.addAttribute("loginMessage", "Login successful");

        return "login/login-info";
    }
}
/*
login/login-info.html

<h1 th:text = "${email}"></h1>
<h1 th:text = "${phoneNumber}"></h1>
<h1 th:text = "${loginMessage}"></h1>

 */