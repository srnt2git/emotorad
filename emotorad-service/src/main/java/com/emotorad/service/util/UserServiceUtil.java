package com.emotorad.service.util;


import com.emotorad.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceUtil {

    @Autowired
    UserService userService;

    public   User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user= (User) authentication.getPrincipal();
        return user;
    }

}
