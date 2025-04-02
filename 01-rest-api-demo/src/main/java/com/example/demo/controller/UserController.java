package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping
    public String getAllUsers(){
        return "List of users";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id){
        return "User detail with id "+ id;
    }

    @PostMapping
    public String createUser(@RequestBody String user){
        return "User created with request body: "+ user;
    }

    @PutMapping("/{id}")
    public  String updateUserById(@PathVariable Long id, @RequestBody String user){
        return "User with id: "+ id + " updated with request body: "+ user;
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id){
        return "User deleted with id: "+ id;
    }
}
