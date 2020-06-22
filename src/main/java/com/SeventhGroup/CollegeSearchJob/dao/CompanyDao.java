package com.SeventhGroup.CollegeSearchJob.dao;


import com.SeventhGroup.CollegeSearchJob.entity.CompanyEntity;
import com.SeventhGroup.CollegeSearchJob.entity.CompanyinfoEntity;
import com.SeventhGroup.CollegeSearchJob.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDao extends JpaRepository<CompanyEntity,String> {

    List<CompanyEntity> findByCompanyEmail(String companyEmail);
    List<CompanyEntity> findByComName(String comName);
    List<CompanyEntity> findByComPassword(String comPassword);
   // List<CompanyEntity> findByTag(String tag);

    //List<User> findByEmail(String email);
    List<CompanyEntity> findByCompanyEmailAndComPassword(String companyEmail,String comPassword);
     @Modifying
    void deleteById(String companyId);

}
