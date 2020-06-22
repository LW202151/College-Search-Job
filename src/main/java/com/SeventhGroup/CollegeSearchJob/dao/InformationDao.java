package com.SeventhGroup.CollegeSearchJob.dao;


import com.SeventhGroup.CollegeSearchJob.entity.informationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationDao extends JpaRepository<informationEntity, String> {

   List<informationEntity> findByUserId(String userId);

   @Modifying
   void deleteByUserId(String userId);



}
