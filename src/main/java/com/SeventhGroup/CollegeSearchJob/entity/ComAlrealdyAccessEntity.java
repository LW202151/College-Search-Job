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

    public ComAlrealdyAccessEntity(String id, String resumeId, String companyId) {
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
