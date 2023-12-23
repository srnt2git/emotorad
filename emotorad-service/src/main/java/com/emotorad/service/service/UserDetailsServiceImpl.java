package com.emotorad.service.service;

import com.emotorad.service.mapper.UserMapper;
import com.emotorad.service.repo.UserRepository;
import com.emotorad.service.repo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        com.emotorad.service.dto.UserDetails userDetails = null;
        User byEmail = userRepository.findByEmail(emailId);
        if (byEmail != null) {
            userDetails = new com.emotorad.service.dto.UserDetails(byEmail.getEmail());
        } else {
            byEmail = new com.emotorad.service.repo.entity.User();
            byEmail.setEmail(emailId);
            userDetails = new com.emotorad.service.dto.UserDetails(emailId);
            User use = new User();
            use.setEmail(emailId);
            User save = userRepository.save(use);
        }
        return userDetails;
    }


}