package com.emotorad.service.mapper;

import com.emotorad.service.dto.ContactDto;
import com.emotorad.service.dto.UserDto;
import com.emotorad.service.repo.entity.Contact;
import com.emotorad.service.repo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings(@Mapping(source = "contactDtos",target = "contacts"))
    public User dtoToEntity(UserDto userDto);

    @Mappings(@Mapping(source = "contacts",target = "contactDtos"))
    public UserDto entityToDto(User user);

    public Contact dtoToEntity(ContactDto contactDto);

    public ContactDto entityToDto(Contact contact);

}
