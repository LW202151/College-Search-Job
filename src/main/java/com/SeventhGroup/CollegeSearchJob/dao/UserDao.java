package com.SeventhGroup.CollegeSearchJob.dao;


import com.SeventhGroup.CollegeSearchJob.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,String>{

    List<User> findByEmail(String email);
    List<User> findByName(String name);
    List<User> findByPassword(String Password);

    //List<User> findByEmail(String email);
    List<User> findByEmailAndPassword(String email,String password);
   // List<User> findByUserId(String userId);
  //List<User> findByUserId(String userId);
    //List<User> findById(String id);
    //List<User> findByPhoneAndPassword(String phone, String password);
  @Modifying
    void deleteById(String userId);
}
