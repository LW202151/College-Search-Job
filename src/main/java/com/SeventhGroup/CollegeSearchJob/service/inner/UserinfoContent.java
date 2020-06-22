package com.SeventhGroup.CollegeSearchJob.service.inner;

import com.SeventhGroup.CollegeSearchJob.entity.informationEntity;

import java.util.List;

public class UserinfoContent {


   // private String email;

    //private String realname;
    List<informationEntity> information;


    public UserinfoContent(List<informationEntity> information) {
        this.information = information;
    }


    public List<informationEntity> getInformation() {
        return information;
    }


    public void setInformation(List<informationEntity> information) {
        this.information = information;
    }
}


