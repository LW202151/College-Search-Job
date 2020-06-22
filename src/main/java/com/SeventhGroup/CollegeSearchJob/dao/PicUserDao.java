package com.SeventhGroup.CollegeSearchJob.dao;

import com.SeventhGroup.CollegeSearchJob.entity.PicUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicUserDao extends JpaRepository<PicUserEntity,String> {
        List<PicUserEntity> findByUserId(String userId);


        @Modifying
        void deleteByUserId(String userId);
}
