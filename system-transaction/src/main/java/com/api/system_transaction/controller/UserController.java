package com.api.system_transaction.controller;

import com.api.system_transaction.DTOS.UserDTO;
import com.api.system_transaction.domain.user.User;
import com.api.system_transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User>createUser(@RequestBody UserDTO userDTO){

        User newUser = userService.createUser(userDTO);
        return new ResponseEntity<>(newUser , HttpStatus.CREATED);

    }




}
