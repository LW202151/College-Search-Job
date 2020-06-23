package com.SeventhGroup.CollegeSearchJob.dao;

import com.SeventhGroup.CollegeSearchJob.entity.CheckcodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckcodeDao extends JpaRepository<CheckcodeEntity,String> {

    List<CheckcodeEntity> findByCode(String code);

}
