package com.SeventhGroup.CollegeSearchJob.service.inner;

import com.SeventhGroup.CollegeSearchJob.entity.SaveresumeAccessEntity;

public class SaveresumeAccess {

    private SaveresumeAccessEntity entity;
    private String url;

    public SaveresumeAccess(SaveresumeAccessEntity entity, String url) {
        this.entity = entity;
        this.url = url;
    }

    public SaveresumeAccessEntity getEntity() {
        return entity;
    }

    public void setEntity(SaveresumeAccessEntity entity) {
        this.entity = entity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
