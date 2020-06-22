package com.SeventhGroup.CollegeSearchJob.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="resume")
@NoArgsConstructor
public class ResumeEntity {

    @Id
    private String resumeId;
    private String userId;
    private String retime;
    private String rekey;

    public ResumeEntity(String resumeId, String userId, String retime, String rekey) {
        this.resumeId = resumeId;
        this.userId = userId;
        this.retime = retime;
        this.rekey = rekey;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRetime() {
        return retime;
    }

    public void setRetime(String retime) {
        this.retime = retime;
    }

    public String getRekey() {
        return rekey;
    }

    public void setRekey(String rekey) {
        this.rekey = rekey;
    }
}
