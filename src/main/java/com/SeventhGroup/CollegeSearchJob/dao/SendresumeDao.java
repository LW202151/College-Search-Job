package com.SeventhGroup.CollegeSearchJob.dao;


import com.SeventhGroup.CollegeSearchJob.entity.ResumeEntity;
import com.SeventhGroup.CollegeSearchJob.entity.SendresumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SendresumeDao extends JpaRepository<SendresumeEntity ,String> {

    List<SendresumeEntity> findByUserId(String userId);
    List<SendresumeEntity> findByResumeId(String resumeId);
    List<SendresumeEntity> findByUserIdAndApplicationId(String userId,String applicationId);
    List<SendresumeEntity> findByCompanyId(String companyId);
    List<SendresumeEntity> findByUserIdAndCompanyId(String userId,String companyId);
    List<SendresumeEntity> findByCompanyIdAndApplicationId(String companyId,String application);
    @Modifying
    void deleteByApplicationId(String applicationId);
    void deleteByCompanyId(String companyId);
    void deleteByUserId(String userId);
    void deleteByResumeId(String resumeId);





}
