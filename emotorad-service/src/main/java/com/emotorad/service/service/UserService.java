package com.emotorad.service.service;

import com.emotorad.service.dto.UserDto;
import com.emotorad.service.mapper.UserMapper;
import com.emotorad.service.repo.UserRepository;
import com.emotorad.service.repo.entity.Contact;
import com.emotorad.service.repo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    public void saveUser(UserDto userDto) {
        User user = userMapper.dtoToEntity(userDto);
        List<User> users = (List<User>) userRepository.findAll();
        if (users.contains(user)) {
            List<Contact> contacts = user.getContacts();
            user.getContacts().forEach(c -> {
                c.setLinkPrecedence("PRIMARY");
            });
            contacts.stream().findFirst().ifPresent(c -> {
                c.setLinkPrecedence("SECONDARY");
            });
            contacts.addAll(user.getContacts());
            userRepository.save(user);
        }
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }
}