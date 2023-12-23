package com.emotorad.service.mapper;

import com.emotorad.service.dto.ContactDto;
import com.emotorad.service.dto.UserDto;
import com.emotorad.service.repo.entity.Contact;
import com.emotorad.service.repo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Configuration
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    @Mappings(@Mapping(source = "contactDtos", target = "contacts"))
    public User dtoToEntity(UserDto userDto);

    @Mappings(@Mapping(source = "contacts", target = "contactDtos"))
    public UserDto entityToDto(User user);

    @Mappings({@Mapping(source = "contactDto.createdAt", target = "createdAt", qualifiedByName = "convertStringToLocaldate")})
    public Contact dtoToEntity(ContactDto contactDto);

    @Named("convertStringToLocaldate")
    default LocalDateTime convertStringToLocaldate(String dateTimeString) {
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);
        // Parse string to LocalDateTime with custom format
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, customFormatter);
        return localDateTime;

    }

    default String convertLocalToString(LocalDateTime localDateTime) {
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);
        String format = customFormatter.format(localDateTime);
        return format;
    }

    public ContactDto entityToDto(Contact contact);

}
