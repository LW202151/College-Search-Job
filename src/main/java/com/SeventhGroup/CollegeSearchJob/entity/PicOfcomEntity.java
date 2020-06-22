package com.SeventhGroup.CollegeSearchJob.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="picOfcom")
@NoArgsConstructor
public class PicOfcomEntity {
    @Id
    private String companyId;
    private String picOfkey;

    public PicOfcomEntity(String companyId, String picOfkey) {
        this.companyId = companyId;
        this.picOfkey = picOfkey;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getPicOfkey() {
        return picOfkey;
    }

    public void setPicOfkey(String picOfkey) {
        this.picOfkey = picOfkey;
    }
}
