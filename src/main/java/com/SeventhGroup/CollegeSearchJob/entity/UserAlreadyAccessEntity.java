package com.SeventhGroup.CollegeSearchJob.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "useralreadyAccess")
@NoArgsConstructor
public class UserAlreadyAccessEntity {
    @Id
    private String id;
    private String resumeId;
    private String userId;
  //  private String useralreadykey;

    public UserAlreadyAccessEntity(String id, String resumeId, String userId) {
        this.id = id;
        this.resumeId = resumeId;
        this.userId = userId;
        //this.useralreadykey = useralreadykey;
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
