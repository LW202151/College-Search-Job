package com.SeventhGroup.CollegeSearchJob.dao;


import com.SeventhGroup.CollegeSearchJob.entity.PicOfappEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicOfappDao extends JpaRepository<PicOfappEntity,String> {

    List<PicOfappEntity> findByApplicationId(String applicationId);

    @Modifying
    void deleteByApplicationId(String applicationId);
}
