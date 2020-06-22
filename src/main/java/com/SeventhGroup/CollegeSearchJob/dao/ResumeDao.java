package com.SeventhGroup.CollegeSearchJob.dao;


import com.SeventhGroup.CollegeSearchJob.entity.ResumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeDao extends JpaRepository<ResumeEntity,String> {

    List<ResumeEntity> findByUserId(String userId);
    List<ResumeEntity> findByResumeId(String resumeId);

    @Modifying
    void deleteByResumeId(String resumeId);



}
