package hu.hittanacs.login.controller;

import hu.hittanacs.login.service.UserService;
import hu.hittanacs.login.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/{userName}", method= RequestMethod.GET)
    public List<User> getUser(@PathVariable String userName) {
        return userService.getAllUser(userName);
    }

}
