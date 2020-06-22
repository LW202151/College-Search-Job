package com.SeventhGroup.CollegeSearchJob.dao;

import com.SeventhGroup.CollegeSearchJob.entity.UserinfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserinfoDao extends JpaRepository<UserinfoEntity,String> {

   List<UserinfoEntity> findByuserId(String userId);

   @Modifying
   void deleteByUserId(String userId);

}
