package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class UserController {
   private UserService userService;

    public UserController() {
    }
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("user")
    public ResponseEntity<?>  setUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);

    }
    @GetMapping("user")
    public ResponseEntity<?>  getbyid(@PathVariable int id){
        User retreive = userService.getUserById(id);
        return new ResponseEntity<>(retreive, HttpStatus.OK);

    }
}
