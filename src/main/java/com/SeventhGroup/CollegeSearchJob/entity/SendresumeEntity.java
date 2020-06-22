package com.SeventhGroup.CollegeSearchJob.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "sendresume")
public class SendresumeEntity {

    @Id
    private String id;
    private String userId;
    private String resumeId;
    private String companyId;
    private String applicationId;
    private String sendtime;
    private String sendkey;

    public SendresumeEntity(){


    }

    public SendresumeEntity(String id, String userId, String resumeId, String companyId, String applicationId, String sendtime, String sendkey) {
        this.id = id;
        this.userId = userId;
        this.resumeId = resumeId;
        this.companyId = companyId;
        this.applicationId = applicationId;
        this.sendtime = sendtime;
        this.sendkey = sendkey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public String getSendkey() {
        return sendkey;
    }

    public void setSendkey(String sendkey) {
        this.sendkey = sendkey;
    }
}
