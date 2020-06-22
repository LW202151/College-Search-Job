package com.SeventhGroup.CollegeSearchJob.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="picUser")
@NoArgsConstructor
public class PicUserEntity {
    @Id
    private String userId;
    private String pickey;

    public PicUserEntity(String userId, String pickey) {
        this.userId = userId;
        this.pickey = pickey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPickey() {
        return pickey;
    }

    public void setPickey(String pickey) {
        this.pickey = pickey;
    }

}
