package com.SeventhGroup.CollegeSearchJob.service.inner;

import com.SeventhGroup.CollegeSearchJob.entity.ResumeEntity;

public class Resume {

    private ResumeEntity entity;

    //文件地址
    private String url;

    public Resume(ResumeEntity entity, String url) {
        this.entity = entity;
        this.url = url;
    }

    public ResumeEntity getEntity() {
        return entity;
    }

    public void setEntity(ResumeEntity entity) {
        this.entity = entity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
