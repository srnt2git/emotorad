package com.emotorad.service.controller;

import com.emotorad.service.dto.UserDto;
import com.emotorad.service.repo.entity.User;
import com.emotorad.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping(value = "/saveUser",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Object> saveUser(@Valid @RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return ResponseEntity.ok("Ok");
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
