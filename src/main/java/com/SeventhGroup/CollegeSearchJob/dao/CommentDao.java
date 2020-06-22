package com.SeventhGroup.CollegeSearchJob.dao;


import com.SeventhGroup.CollegeSearchJob.entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<CommentsEntity,String> {
        List<CommentsEntity> findByUserId(String userId);
        List<CommentsEntity> findByApplicationId(String applicationId);
        List<CommentsEntity> findByCompanyId(String companyId);
        List<CommentsEntity> findByCommentId(String commentId);
        @Modifying
        void deleteByCommentId(String commentId);
        void deleteByApplicationId(String applicationId);
        void deleteByCompanyId(String companyId);
        void deleteByUserId(String userId);




}
