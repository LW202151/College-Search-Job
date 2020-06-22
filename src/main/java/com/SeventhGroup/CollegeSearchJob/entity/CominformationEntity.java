package com.SeventhGroup.CollegeSearchJob.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="cominformation")
@NoArgsConstructor
public class CominformationEntity {

    @Id
    private String id;
    private String companyName;
    private String nature;
    private String comTime;
    private String description;
    private String address;
    private String web;
    private String mailbox;
    private String companyId;
    //private String tag;


    public CominformationEntity(String id, String companyName, String nature, String comTime, String description, String address, String web, String mailbox, String companyId) {
        this.id = id;
        this.companyName = companyName;
        this.nature = nature;
        this.comTime = comTime;
        this.description = description;
        this.address = address;
        this.web = web;
        this.mailbox = mailbox;
        this.companyId = companyId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getComTime() {
        return comTime;
    }

    public void setComTime(String comTime) {
        this.comTime = comTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
