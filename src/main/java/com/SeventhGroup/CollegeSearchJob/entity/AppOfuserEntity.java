package com.SeventhGroup.CollegeSearchJob.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="appofuser")
@NoArgsConstructor
public class AppOfuserEntity {

    @Id
    private String applicationId;
    private String userId;

    public AppOfuserEntity(String applicationId, String userId) {
        this.applicationId = applicationId;
        this.userId = userId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
