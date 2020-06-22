package com.SeventhGroup.CollegeSearchJob.dao;


import com.SeventhGroup.CollegeSearchJob.entity.ResumeOfthreeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public interface ResumeOfthreeDao extends JpaRepository<ResumeOfthreeEntity,String> {
    List<ResumeOfthreeEntity> findByResumeId(String resumeId);
    List<ResumeOfthreeEntity> findByCompanyId(String companyId);
    List<ResumeOfthreeEntity> findByUserId(String userId);
    List<ResumeOfthreeEntity> findByCompanyIdAndResumeId(String companyId,String resumeId);
    List<ResumeOfthreeEntity> findByUserIdAndApplicationId(String userId, String applicationId);
    List<ResumeOfthreeEntity> findByUserIdAndCompanyId(String userId, String companyId);

     @Modifying
     void deleteByCompanyId(String companyId);
     void deleteByApplicationId(String application);
     void deleteByUserId(String userId);




}
