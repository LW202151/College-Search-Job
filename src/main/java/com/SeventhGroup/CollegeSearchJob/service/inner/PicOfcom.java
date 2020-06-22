package com.SeventhGroup.CollegeSearchJob.service.inner;

import com.SeventhGroup.CollegeSearchJob.entity.CominformationEntity;

public class PicOfcom {
    private CominformationEntity cominfoEntity;
    //图片地址
    private String url;

    public PicOfcom(CominformationEntity cominfoEntity, String url) {
        this.cominfoEntity = cominfoEntity;
        this.url = url;
    }

    public CominformationEntity getCominfoEntity() {
        return cominfoEntity;
    }

    public void setCominfoEntity(CominformationEntity cominfoEntity) {
        this.cominfoEntity = cominfoEntity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
