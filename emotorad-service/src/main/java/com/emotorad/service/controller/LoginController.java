package com.emotorad.service.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@Controller
public class LoginController {

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "index";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String loginSuccess(@RequestHeader("email") @Valid  @Email String email) {
        return "index";
    }


}
