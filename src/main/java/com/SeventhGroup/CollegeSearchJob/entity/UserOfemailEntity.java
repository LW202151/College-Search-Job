package com.SeventhGroup.CollegeSearchJob.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="userofemail")
@NoArgsConstructor
public class UserOfemailEntity {

    @Id
    private String userId;
    private String email;

    public UserOfemailEntity(String userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
