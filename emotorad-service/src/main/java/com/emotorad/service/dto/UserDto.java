package com.emotorad.service.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDto {

    private int id;
    private int phoneNumber;

    private String email;
   private List<ContactDto> contactDtos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
