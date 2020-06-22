package com.SeventhGroup.CollegeSearchJob.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="appOfcom")
@NoArgsConstructor
public class AppOfcomEntity {

    @Id
    private String applicationId;
    private String companyId;
    public AppOfcomEntity(String applicationId, String companyId) {
        this.applicationId = applicationId;
        this.companyId = companyId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
