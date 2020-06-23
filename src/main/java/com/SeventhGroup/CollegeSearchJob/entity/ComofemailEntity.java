package com.SeventhGroup.CollegeSearchJob.entity;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="comofemail")
@NoArgsConstructor
public class ComofemailEntity {

    @Id
    private String companyId;
    private String companyEmail;

    public ComofemailEntity(String companyId, String companyEmail) {
        this.companyId = companyId;
        this.companyEmail = companyEmail;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }
}
