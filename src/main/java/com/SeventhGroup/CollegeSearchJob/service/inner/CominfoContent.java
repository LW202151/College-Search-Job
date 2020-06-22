package com.SeventhGroup.CollegeSearchJob.service.inner;

import com.SeventhGroup.CollegeSearchJob.entity.CominformationEntity;

import java.util.List;

public class CominfoContent {
    List<CominformationEntity> cominformation;

    public CominfoContent(List<CominformationEntity> cominformation) {
        this.cominformation = cominformation;
    }

    public List<CominformationEntity> getCominformation() {
        return cominformation;
    }

    public void setCominformation(List<CominformationEntity> cominformation) {
        this.cominformation = cominformation;
    }
}
