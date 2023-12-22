package com.emotorad.service.controller;

import com.emotorad.service.dto.UserDto;
import com.emotorad.service.repo.entity.User;
import com.emotorad.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/saveUser")
    public void saveUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @GetMapping("/getAll")
    public Iterable<User> getAll() {
        return userService.getAllUser();
    }

    @GetMapping("/findByMail")
    public UserDto findByMail() {
        return userService.findByEmail();
    }

    @PostMapping(value = {"/addTest"})
    public void addTestUser() {
        UserDto userDto = new UserDto();
        userDto.setEmail("raja@gmail.com");
        userService.saveUser(userDto);
    }
}
