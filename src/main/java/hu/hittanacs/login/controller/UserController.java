package hu.hittanacs.login.controller;

import hu.hittanacs.login.service.UserServiceImpl;
import hu.hittanacs.login.model.User;
import hu.hittanacs.login.util.EmailCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> updateUser(@RequestBody User user) {

        if (EmailCheck.validate(user.getEmail())) {
                userService.update(user);
                return new ResponseEntity<String>("Succes", HttpStatus.OK);
        }else
        {
            return new ResponseEntity<String>("Wrong Email Address", HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        userService.removeById(id);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<String> uploadUser(@RequestBody User user){
        if (EmailCheck.validate(user.getEmail())) {
            userService.upload(user);
            return new ResponseEntity<String>("Succes", HttpStatus.OK);
        }else
        {
            return new ResponseEntity<String>("Wrong Email Address", HttpStatus.UNAUTHORIZED);
        }
    }
}
