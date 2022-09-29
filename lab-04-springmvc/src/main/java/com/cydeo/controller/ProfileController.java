package com.cydeo.controller;

import com.cydeo.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class ProfileController {

    @RequestMapping("/profile")
    public String retrieveProfile(Model model) {

        Profile profile1 = new Profile();
//        Profile profile1 = new Profile("gmail@gmail.com", "12350068", "Mike", "Smith", "mike77", LocalDateTime.now());

        profile1.setName("James");
        profile1.setSurname("Born");
        profile1.setUserName("807");
        profile1.setEmail("born@gmail.com");
        profile1.setPhoneNumber("00585855");
        profile1.setCreatedDate(LocalDateTime.now());

        model.addAttribute("profile", profile1);

        return "profile/profile-info.html";
    }

}
/*

profile/profile-info.html
h1 th:text = "${profile.getName()}"></h1>
<h1 th:text = "${profile.getSurname()}"></h1>
<h1 th:text = "${profile.getUserName()}"></h1>
<h1 th:text = "${profile.getPhoneNumber()}"></h1>
<h1 th:text = "${profile.getEmail()}"></h1>
<h1 th:text = "${profile.getCreatedDate()}"></h1>
 */