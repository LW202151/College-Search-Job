package com.SeventhGroup.CollegeSearchJob.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "checkcode")
@NoArgsConstructor
public class CheckcodeEntity {

    @Id
    private String id;
    private String code;

    public CheckcodeEntity(String id, String code) {
        this.id = id;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
