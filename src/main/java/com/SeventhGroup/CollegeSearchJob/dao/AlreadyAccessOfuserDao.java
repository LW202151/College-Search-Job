package com.SeventhGroup.CollegeSearchJob.dao;

import com.SeventhGroup.CollegeSearchJob.entity.UserAlreadyAccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlreadyAccessOfuserDao extends JpaRepository<UserAlreadyAccessEntity,String> {

    List<UserAlreadyAccessEntity> findByUserId(String userId);
    @Modifying
    void deleteByResumeId(String resumeId );
    void deleteByUserId(String userId);
}
