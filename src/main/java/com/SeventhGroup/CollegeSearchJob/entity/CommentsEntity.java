package com.SeventhGroup.CollegeSearchJob.entity;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="comment")
@NoArgsConstructor
public class CommentsEntity {

    @Id
    private String commentId;
    private String userId;
    private String companyId;
    private String applicationId;
    private String content;
    private String commenttime;

    public CommentsEntity(String commentId, String userId, String companyId, String applicationId, String content, String commenttime) {
        this.commentId = commentId;
        this.userId = userId;
        this.companyId = companyId;
        this.applicationId = applicationId;
        this.content = content;
        this.commenttime = commenttime;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(String commenttime) {
        this.commenttime = commenttime;
    }
}
