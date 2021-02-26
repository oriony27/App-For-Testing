package com.app.testing.controller;

import com.app.testing.model.User;
import com.app.testing.model.impl.UserImpl;
import com.app.testing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(value = "limit") int limit, @RequestParam(value = "offset") int offset) {
        List<User> users = userService.getAllUsers(limit, offset);

        if (users != null) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getUserById")
    public ResponseEntity<User> getUserById(@RequestParam(value = "id") long id) {
        User user = userService.getUserById(id);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody UserImpl user) {
        User createdUser = userService.createUser(user);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody UserImpl user) {
        User createdUser = userService.updateUser(user);

        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<Object> deleteUserById(@RequestParam(value = "id") long id) {

        if(userService.deleteUser(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}