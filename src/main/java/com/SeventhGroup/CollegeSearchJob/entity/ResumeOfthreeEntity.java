package com.SeventhGroup.CollegeSearchJob.entity;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "resumeOfthree")
@NoArgsConstructor
public class ResumeOfthreeEntity {
    @Id
    private String id;
    private String userId;
    private String companyId;
    private String applicationId;
    private String resumeId;
    private  String threekey;

    public ResumeOfthreeEntity(String id, String userId, String companyId, String applicationId, String resumeId, String threekey) {
        this.id = id;
        this.userId = userId;
        this.companyId = companyId;
        this.applicationId = applicationId;
        this.resumeId = resumeId;
        this.threekey = threekey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }


    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getThreekey() {
        return threekey;
    }

    public void setThreekey(String threekey) {
        this.threekey = threekey;
    }
}
