package com.SeventhGroup.CollegeSearchJob.dao;

import com.SeventhGroup.CollegeSearchJob.entity.PicOfcomEntity;
import com.SeventhGroup.CollegeSearchJob.entity.PicUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicOfcomDao extends JpaRepository<PicOfcomEntity ,String>{
    List<PicOfcomEntity> findByCompanyId(String companyId);

@Modifying
void deleteByCompanyId(String companyId);

}
