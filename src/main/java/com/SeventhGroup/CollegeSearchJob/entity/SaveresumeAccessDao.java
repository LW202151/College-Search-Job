package com.SeventhGroup.CollegeSearchJob.entity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaveresumeAccessDao extends JpaRepository<SaveresumeAccessEntity,String> {

    List<SaveresumeAccessEntity> findByUserId(String userId);
    List<SaveresumeAccessEntity> findByCompanyId(String companyId);
    List<SaveresumeAccessEntity> findByCompanyIdAndResumeId(String companyId,String resumeId);

}
