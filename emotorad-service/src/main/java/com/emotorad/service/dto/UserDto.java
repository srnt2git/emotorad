package com.emotorad.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDto {

    private String id;
    private int phoneNumber;

    @Email
    private String email;

    @JsonProperty("contacts")
   private List<ContactDto> contactDtos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ContactDto> getContactDtos() {
        return contactDtos;
    }

    public void setContactDtos(List<ContactDto> contactDtos) {
        this.contactDtos = contactDtos;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
