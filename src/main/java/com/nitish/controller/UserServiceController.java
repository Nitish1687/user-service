package com.nitish.controller;

import com.nitish.bean.User;
import com.nitish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by nsm1211 on 16-09-2015.
 */
@RestController
public class UserServiceController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get/{userId}/user", method = GET)
    public @ResponseBody User getUserByID(@PathVariable int userId) {
        User user = userService.getUserFor(userId);
        return user;
    }

    @RequestMapping(value = "/add/user", method = POST)
    public @ResponseBody User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
