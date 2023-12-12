package com.bayu.web.controller;

import com.bayu.web.entity.Post;
import com.bayu.web.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class WebController {

    @GetMapping(path = "/users")
    public List<User> getUsers() {
//        return Arrays.asList(
//                new User("John Doe", 25),
//                new User("Jane Doe", 30),
//                new User("Bob Smith", 22)
//        );
        User user1 = new User("John Doe", 25);
        User user2 = new User("Jane Doe", 30);

        Post post1 = new Post("First Post", "", user1);

        return Arrays.asList(user1, user2);
    }


    /**
     * Ketika user akses endpoint /home maka akan dirender template index.html
     * @return ModelAndView can render into Thymeleaf
     */
    @GetMapping("/home")
    public ModelAndView home() {
        List<User> userList = Arrays.asList(
                new User("John Doe", 25),
                new User("Jane Doe", 30),
                new User("Bob Smith", 22)
        );

        // index points to html template
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("users", userList);

        return modelAndView;
    }
}
