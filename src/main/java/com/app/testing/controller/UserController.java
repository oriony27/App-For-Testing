package com.app.testing.controller;

import com.app.testing.entity.User;
import com.app.testing.exception.impl.ValidationExceptions;
import com.app.testing.service.UserService;
import com.app.testing.utils.GsonUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final static Logger logger = Logger.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(value = "limit") int limit, @RequestParam(value = "offset") int offset) {
        List<User> users = userService.getAllUsers(limit, offset);
        logger.info(MessageFormat.format("Page params: limit is {0}, offset is {1}", limit, offset));
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getUserById")
    public ResponseEntity<User> getUserById(@RequestParam(value = "id") long id) throws ValidationExceptions.NoSuchUser {
        logger.info(MessageFormat.format("Passed user id is {0}", id));
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) throws ValidationExceptions.UserAlreadyExists {
        logger.info(MessageFormat.format("Passed user to create is {0}", GsonUtils.toJson(user)));
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        logger.info(MessageFormat.format("Passed user to update is {0}", GsonUtils.toJson(user)));
        User createdUser = userService.updateUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUserById(@RequestParam(value = "id") long id) {
        logger.info(MessageFormat.format("Passed user id is {0}", id));
        userService.deleteUser(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}