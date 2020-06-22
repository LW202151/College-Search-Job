package com.SeventhGroup.CollegeSearchJob.service.inner;

import com.SeventhGroup.CollegeSearchJob.entity.ResumeOfthreeEntity;

public class ResumeOfthree {
    private ResumeOfthreeEntity entity;
    private String url;

    public ResumeOfthree(ResumeOfthreeEntity entity, String url) {
        this.entity = entity;
        this.url = url;
    }

    public ResumeOfthreeEntity getEntity() {
        return entity;
    }

    public void setEntity(ResumeOfthreeEntity entity) {
        this.entity = entity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
