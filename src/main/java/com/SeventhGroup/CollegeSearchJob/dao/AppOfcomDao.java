package com.SeventhGroup.CollegeSearchJob.dao;


import com.SeventhGroup.CollegeSearchJob.entity.AppOfcomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppOfcomDao extends JpaRepository<AppOfcomEntity,String> {

    List<AppOfcomEntity> findByApplicationId(String applicationId);

    List<AppOfcomEntity> findByCompanyId(String companyId);
    List<AppOfcomEntity> findByCompanyIdAndApplicationId(String companyId,String applicationId);
    @Modifying
    void deleteByApplicationId(String applicationId);
    void deleteByCompanyId(String companyId);


}
