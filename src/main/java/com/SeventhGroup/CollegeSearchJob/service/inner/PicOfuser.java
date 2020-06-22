package com.SeventhGroup.CollegeSearchJob.service.inner;

import com.SeventhGroup.CollegeSearchJob.entity.informationEntity;

public class PicOfuser {
    private informationEntity entity;
    //图片地址
    private String url;


    public PicOfuser(informationEntity entity, String url) {
        this.entity = entity;
        this.url = url;
    }

    public informationEntity getEntity() {
        return entity;
    }

    public void setEntity(informationEntity entity) {
        this.entity = entity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void save(PicOfuser urlop) {
    }
}
