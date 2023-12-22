package com.emotorad.service.service;

import com.emotorad.service.dto.UserDto;
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
        com.emotorad.service.dto.UserDetails userDetails=null;
        UserDto byEmail = userService.findByEmail(emailId);
        if(byEmail!=null){
             userDetails=new com.emotorad.service.dto.UserDetails(byEmail.getEmail());
        }else{
            byEmail=new UserDto();
            byEmail.setEmail(emailId);
            userService.saveUser(byEmail);
            userDetails=new com.emotorad.service.dto.UserDetails(emailId);
        }
        return userDetails;
    }



}