package com.SeventhGroup.CollegeSearchJob.dao;

import com.SeventhGroup.CollegeSearchJob.entity.AppOfcomEntity;
import com.SeventhGroup.CollegeSearchJob.entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchDao extends JpaRepository<ApplicationEntity, String> {

    List<ApplicationEntity> findByApplicationId(String applicationId);
   // List<ApplicationEntity> findByComName(String comName);
    //List<ApplicationEntity> findByPosition(String position);
    //List<ApplicationEntity> findByTag(String tag);
   // List<ApplicationEntity> findByCompanyId(String companyId);

    @Query(value="select * from application  where comName like CONCAT('%',:comName,'%')",nativeQuery=true)
    List<ApplicationEntity> findByComName(@Param("comName") String comName);


    @Query(value="select * from application  where position like CONCAT('%',:position,'%')",nativeQuery=true)
    List<ApplicationEntity> findByPosition(@Param("position") String position);

    @Query(value="select * from application  where tag like CONCAT('%',:tag,'%')",nativeQuery=true)
    List<ApplicationEntity> findByTag(@Param("tag") String tag);





    @Modifying
    void deleteByApplicationId(String applicationId);
   //void deleteByUserId(String userId);
   //void deleteByCompanyId(String companyId);


}
