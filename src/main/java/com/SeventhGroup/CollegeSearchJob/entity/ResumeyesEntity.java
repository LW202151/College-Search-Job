package com.SeventhGroup.CollegeSearchJob.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "resumeyes")
public class ResumeyesEntity {

    @Id
    private String id;
    private String resumeId;
    private String companyId;

    public ResumeyesEntity(String id, String resumeId, String companyId) {
        this.id = id;
        this.resumeId = resumeId;
        this.companyId = companyId;
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

}
