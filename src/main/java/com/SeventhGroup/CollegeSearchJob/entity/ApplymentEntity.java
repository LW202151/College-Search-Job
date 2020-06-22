package com.SeventhGroup.CollegeSearchJob.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "applyment")
@NoArgsConstructor
public class ApplymentEntity {
    @Id
    private String user_id;
    private String applyment_id;

    public ApplymentEntity(String user_id, String applyment_id) {
        this.user_id = user_id;
        this.applyment_id = applyment_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getApplyment_id() {
        return applyment_id;
    }

    public void setApplyment_id(String applyment_id) {
        this.applyment_id = applyment_id;
    }
}
