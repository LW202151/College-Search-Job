package com.SeventhGroup.CollegeSearchJob.entity;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "userAccessyes")
@NoArgsConstructor
public class UserAccessyesEntity {

    @Id
    private String id;
    private String resumeId;
    private String userId;

    public UserAccessyesEntity(String id, String resumeId, String userId) {
        this.id = id;
        this.resumeId = resumeId;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
