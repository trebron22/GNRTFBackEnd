package hu.hittanacs.login.controller;

import hu.hittanacs.login.service.UserServiceImpl;
import hu.hittanacs.login.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value="/get/{id}", method= RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        userService.update(user);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        userService.removeById(id);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void uploadUser(@RequestBody User user){
        userService.upload(user);
    }
}
