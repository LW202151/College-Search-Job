package com.SeventhGroup.CollegeSearchJob.dao;


import com.SeventhGroup.CollegeSearchJob.entity.HistoryofEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryDao extends JpaRepository<HistoryofEntity,String> {


    List<HistoryofEntity> findAllByUserIdAndType(String userId, String type);
    List<HistoryofEntity> findAllByCompanyIdAndType(String companyId, String type);


}
