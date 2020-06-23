package com.SeventhGroup.CollegeSearchJob.dao;

import com.SeventhGroup.CollegeSearchJob.entity.ComofemailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComofemailDao extends JpaRepository<ComofemailEntity,String> {
    List<ComofemailEntity> findByCompanyId(String companyId);


}
