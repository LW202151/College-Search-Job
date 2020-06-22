package com.SeventhGroup.CollegeSearchJob.dao;

import com.SeventhGroup.CollegeSearchJob.entity.ResumeEntity;
import com.SeventhGroup.CollegeSearchJob.entity.SendresumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeyesDao extends JpaRepository<SendresumeEntity,String> {

    List<SendresumeEntity> findByCompanyId(String companyId);
    List<SendresumeEntity> findByResumeId(String resumeId);
}
