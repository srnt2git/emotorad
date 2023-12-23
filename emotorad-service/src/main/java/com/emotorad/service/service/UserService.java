package com.emotorad.service.service;

import com.emotorad.service.config.SpringSecurityConfig;
import com.emotorad.service.dto.UserDetails;
import com.emotorad.service.dto.UserDto;
import com.emotorad.service.mapper.UserMapper;
import com.emotorad.service.repo.UserRepository;
import com.emotorad.service.repo.entity.Contact;
import com.emotorad.service.repo.entity.User;
import com.emotorad.service.util.UserServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {


    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceUtil userServiceUtil;

    public void saveUser(UserDto userDto) {
        User users = userRepository.findByEmail(userServiceUtil.getUser().getUsername());
        if(users!=null){
            userDto.getContactDtos().stream().forEach(c->{
                Contact contact=userMapper.dtoToEntity(c);
                users.getContacts().add(contact);
            });
        }
        userRepository.save(users);


    }

    public UserDto findByEmail() {
        UserDetails userDetails = (UserDetails) userServiceUtil.getUser();
        UserDto userDto = userMapper.entityToDto(userRepository.findByEmail(userDetails.getEmail()));
        return userDto;
    }

    public UserDto findByEmail(String email) {
        UserDto userDto = userMapper.entityToDto(userRepository.findByEmail(email));
        return userDto;
    }


    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

}