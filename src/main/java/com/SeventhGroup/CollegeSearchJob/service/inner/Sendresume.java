package com.SeventhGroup.CollegeSearchJob.service.inner;

import com.SeventhGroup.CollegeSearchJob.entity.SendresumeEntity;

public class Sendresume {
    private SendresumeEntity entity;
    private String url;

    public Sendresume(SendresumeEntity entity, String url) {
        this.entity = entity;
        this.url = url;
    }

    public SendresumeEntity getEntity() {
        return entity;
    }

    public void setEntity(SendresumeEntity entity) {
        this.entity = entity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
