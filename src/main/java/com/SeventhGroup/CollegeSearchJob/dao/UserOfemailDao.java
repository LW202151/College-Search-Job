package com.SeventhGroup.CollegeSearchJob.dao;


import com.SeventhGroup.CollegeSearchJob.entity.UserOfemailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOfemailDao extends JpaRepository<UserOfemailEntity,String> {
     List<UserOfemailEntity> findByUserId(String userId);
}
