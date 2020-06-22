package com.SeventhGroup.CollegeSearchJob.entity;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "comalreadyaccess")
@NoArgsConstructor
public class ComAlrealdyAccessEntity {
    @Id
    private String id;
    private String resumeId;
    private String companyId;
    private String applicationId;

    public ComAlrealdyAccessEntity(String id, String resumeId, String companyId, String applicationId) {
        this.id = id;
        this.resumeId = resumeId;
        this.companyId = companyId;
        this.applicationId = applicationId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
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
}
