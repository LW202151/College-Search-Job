package com.SeventhGroup.CollegeSearchJob.service.inner;

import com.SeventhGroup.CollegeSearchJob.entity.ApplicationEntity;

public class PicOfapp {
    private ApplicationEntity entity;
    private String url;

    public PicOfapp(ApplicationEntity entity, String url) {
        this.entity = entity;
        this.url = url;
    }

    public ApplicationEntity getEntity() {
        return entity;
    }

    public void setEntity(ApplicationEntity entity) {
        this.entity = entity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
