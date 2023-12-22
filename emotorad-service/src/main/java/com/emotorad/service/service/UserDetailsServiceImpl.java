package com.emotorad.service.service;

import com.emotorad.service.mapper.UserMapper;
import com.emotorad.service.repo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        User user = userService.findByEmail(emailId);
        com.emotorad.service.dto.UserDetails userDetails=new com.emotorad.service.dto.UserDetails(user.getEmail());
        return userDetails;
    }



}