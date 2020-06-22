package com.SeventhGroup.CollegeSearchJob.entity;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="application")
@NoArgsConstructor
public class ApplicationEntity {
    @Id
    private String applicationId;
    private String comName;
    private String companydesc;
    private String position;
    private String positiondesc;
    private String requirement;
    private Integer num;
    private Float money;
    private String address;
    private String tag;
    private String uptime;

    public ApplicationEntity(String applicationId, String comName, String companydesc, String position, String positiondesc, String requirement, Integer num, Float money, String address,String tag, String uptime) {
        this.applicationId = applicationId;
        this.comName = comName;
        this.companydesc = companydesc;
        this.position = position;
        this.positiondesc = positiondesc;
        this.requirement = requirement;
        this.num = num;
        this.money = money;
        this.address = address;
        this.tag=tag;
        this.uptime = uptime;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getCompanydesc() {
        return companydesc;
    }

    public void setCompanydesc(String companydesc) {
        this.companydesc = companydesc;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositiondesc() {
        return positiondesc;
    }

    public void setPositiondesc(String positiondesc) {
        this.positiondesc = positiondesc;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }
}
