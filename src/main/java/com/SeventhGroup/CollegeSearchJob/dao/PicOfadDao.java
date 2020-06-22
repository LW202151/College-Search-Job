package com.SeventhGroup.CollegeSearchJob.dao;


import com.SeventhGroup.CollegeSearchJob.entity.PicOfappEntity;
import com.SeventhGroup.CollegeSearchJob.entity.PicofadministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicOfadDao extends JpaRepository<PicofadministratorEntity,String> {

    List<PicofadministratorEntity> findByAdministratorId(String administratorId);
}
