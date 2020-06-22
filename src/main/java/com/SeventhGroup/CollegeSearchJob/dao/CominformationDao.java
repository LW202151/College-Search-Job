package com.SeventhGroup.CollegeSearchJob.dao;

import com.SeventhGroup.CollegeSearchJob.entity.CominformationEntity;
import com.SeventhGroup.CollegeSearchJob.entity.informationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CominformationDao extends JpaRepository <CominformationEntity,String>{

    List<CominformationEntity> findByCompanyId(String companyId);
    @Modifying
    void deleteByCompanyId(String companyId);

}
