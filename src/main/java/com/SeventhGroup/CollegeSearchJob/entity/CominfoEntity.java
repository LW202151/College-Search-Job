package com.SeventhGroup.CollegeSearchJob.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="cominfo")
@NoArgsConstructor
public class CominfoEntity {
    @Id
    private String id;
    private String companyId;
    private String cominfoId;
    public CominfoEntity(String id, String companyId, String cominfoId) {
        this.id = id;
        this.companyId = companyId;
        this.cominfoId = cominfoId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCominfoId() {
        return cominfoId;
    }

    public void setCominfoId(String cominfoId) {
        this.cominfoId = cominfoId;
    }
}
