package com.emotorad.service.repo.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@RedisHash("contact")
public class Contact {
    @Id
    private String id;

    private String email;

    private int phoneNumber;

    private int linkedId;

    private String linkPrecedence;

    @CreatedDate
    private LocalDateTime createdAt;


    @LastModifiedDate
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void prePersist() {
        if(createdAt==null){
            this.createdAt = LocalDateTime.now();
        }
        this.updatedAt=LocalDateTime.now();


        // Other auditing information, if needed...
    }

}
