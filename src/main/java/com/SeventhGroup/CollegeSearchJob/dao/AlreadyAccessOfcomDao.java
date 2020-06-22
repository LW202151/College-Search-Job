package com.SeventhGroup.CollegeSearchJob.dao;

import com.SeventhGroup.CollegeSearchJob.entity.ComAlrealdyAccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlreadyAccessOfcomDao extends JpaRepository<ComAlrealdyAccessEntity,String> {

    List<ComAlrealdyAccessEntity> findByCompanyId(String companyId);
    List<ComAlrealdyAccessEntity> findByCompanyIdAndResumeId(String companyId,String resumeId);
    @Modifying
    void deleteByCompanyId(String companyId);

}
