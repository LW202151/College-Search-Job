package com.SeventhGroup.CollegeSearchJob.service.inner;

import com.SeventhGroup.CollegeSearchJob.entity.UserAlreadyAccessEntity;

public class UserAlreadyAccess {

    private UserAlreadyAccessEntity entity;
    private String url;

    public UserAlreadyAccess(UserAlreadyAccessEntity entity, String url) {
        this.entity = entity;
        this.url = url;
    }

    public UserAlreadyAccessEntity getEntity() {
        return entity;
    }

    public void setEntity(UserAlreadyAccessEntity entity) {
        this.entity = entity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
