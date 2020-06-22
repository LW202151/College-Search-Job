package com.SeventhGroup.CollegeSearchJob.entity;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="company")
@NoArgsConstructor
public class CompanyEntity {
     @Id
     private String id;
     private String companyEmail;
     private String comName;
     private String comPassword;

    public CompanyEntity(String id, String companyEmail, String comName, String comPassword) {
        this.id = id;
        this.companyEmail = companyEmail;
        this.comName = comName;
        this.comPassword = comPassword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComPassword() {
        return comPassword;
    }

    public void setComPassword(String comPassword) {
        this.comPassword = comPassword;
    }
}
