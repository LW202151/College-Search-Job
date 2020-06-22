package com.SeventhGroup.CollegeSearchJob.dao;

import com.SeventhGroup.CollegeSearchJob.entity.CominfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CominfoDao extends JpaRepository<CominfoEntity, String> {


    List<CominfoEntity> findBycompanyId(String companyId);
    @Modifying
    void deleteByCompanyId(String companyId);



}
