package com.SeventhGroup.CollegeSearchJob.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "picOfapp")
@NoArgsConstructor
public class PicOfappEntity {

    @Id
    private String applicationId;
    private String appkey;

    public PicOfappEntity(String applicationId, String appkey) {
        this.applicationId = applicationId;
        this.appkey = appkey;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }
}
