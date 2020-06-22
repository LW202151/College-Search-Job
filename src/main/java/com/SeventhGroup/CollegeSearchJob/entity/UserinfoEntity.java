package com.SeventhGroup.CollegeSearchJob.entity;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "userinfo")
@NoArgsConstructor
public class UserinfoEntity {

    @Id
    private String id;

    private String userId;
    private String infoId;

    public UserinfoEntity(String id, String userId, String infoId) {
        this.id = id;
        this.userId = userId;
        this.infoId = infoId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }
}
