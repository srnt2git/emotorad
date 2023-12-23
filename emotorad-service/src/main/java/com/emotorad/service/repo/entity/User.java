package com.emotorad.service.repo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.ArrayList;
import java.util.List;

@RedisHash("user")
public class User {

    private String id;

    private int phoneNumber;

    @Id
    @Indexed
    private String email;

    private List<Contact> contacts=new ArrayList<>();

    @Override
    public boolean equals(Object obj) {

        if(this.email==null || obj ==null){

            return false;
        }
        User user= (User) obj;
        return this.email.equals(user.email) || this.phoneNumber==user.phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

}
