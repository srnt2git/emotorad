package com.emotorad.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDto {

    private String id;
    private String phoneNumber;

    @Email
    private String email;

    @JsonProperty("contacts")
    @Valid
    private List<ContactDto> contactDtos;

    private int linkedId;

    private String linkPrecedence;

    @CreatedDate
    private String createdAt;

    @LastModifiedDate
    private String updatedAt;

    private LocalDateTime deletedAt;


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



    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getLinkedId() {
        return linkedId;
    }

    public void setLinkedId(int linkedId) {
        this.linkedId = linkedId;
    }

    public String getLinkPrecedence() {
        return linkPrecedence;
    }

    public void setLinkPrecedence(String linkPrecedence) {
        this.linkPrecedence = linkPrecedence;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
