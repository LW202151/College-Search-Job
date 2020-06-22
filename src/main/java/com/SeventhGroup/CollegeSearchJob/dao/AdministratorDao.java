package com.SeventhGroup.CollegeSearchJob.dao;

import com.SeventhGroup.CollegeSearchJob.entity.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorDao extends JpaRepository<AdministratorEntity,String> {

   // List<AdministratorEntity> findByAdministratorId(String AdministratorId);
    List<AdministratorEntity> findByEmail(String email);
    List<AdministratorEntity> findByName(String name);
    List<AdministratorEntity> findByPassword(String password);

    List<AdministratorEntity> findByEmailAndPassword(String email,String password);



}
