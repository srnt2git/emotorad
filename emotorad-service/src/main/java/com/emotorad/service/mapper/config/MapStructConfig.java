package com.emotorad.service.mapper.config;

import com.emotorad.service.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapStructConfig {

    @Bean
    public UserMapper userMapper() {
        return UserMapper.INSTANCE;
    }
}
