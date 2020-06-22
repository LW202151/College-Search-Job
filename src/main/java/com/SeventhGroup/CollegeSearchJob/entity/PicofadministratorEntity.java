package com.SeventhGroup.CollegeSearchJob.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Picofadministrator")
@NoArgsConstructor
public class PicofadministratorEntity {

    @Id
    private String administratorId;
    private String adkey;

    public PicofadministratorEntity(String administratorId, String adkey) {
        this.administratorId = administratorId;
        this.adkey = adkey;
    }

    public String getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(String administratorId) {
        this.administratorId = administratorId;
    }

    public String getAdkey() {
        return adkey;
    }

    public void setAdkey(String adkey) {
        this.adkey = adkey;
    }
}
