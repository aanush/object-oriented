package com.student.friendship.controller;

import com.student.friendship.pojo.User;
import com.student.friendship.pojo.UserFactory;
import com.student.friendship.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private final UserFactory userFactory;

    @Autowired
    private final UserService userService;

    public UserController(UserFactory userFactory, UserService userService) {
        this.userFactory = userFactory;
        this.userService = userService;
    }

    // http://localhost:8080/userController/addUser/user01/1
    @RequestMapping(path = "/userController/addUser/{username}/{id}", method = RequestMethod.GET)
    public User addUser(@PathVariable("username") String username, @PathVariable("id") int id) {
        User user = userFactory.createUser(username, id);
        userService.addUser(user);
        return user;
    }

    // http://localhost:8080/userController/getUser/user01
    @RequestMapping(path = "/userController/getUser/{username}", method = RequestMethod.GET)
    public User getUser(@PathVariable("username") String username) {
        User user = userService.getUser(username);
        return user;
    }

}
