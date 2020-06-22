package com.SeventhGroup.CollegeSearchJob.dao;


import com.SeventhGroup.CollegeSearchJob.entity.UserAccessyesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAccessyesDao extends JpaRepository<UserAccessyesEntity,String> {

    List<UserAccessyesEntity> findByUserId(String usreId);
    @Modifying
    void deleteByUserId(String userId);


}
