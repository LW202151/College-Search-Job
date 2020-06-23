package com.SeventhGroup.CollegeSearchJob.service;


import com.SeventhGroup.CollegeSearchJob.dao.CominformationDao;
import com.SeventhGroup.CollegeSearchJob.dao.HistoryDao;
import com.SeventhGroup.CollegeSearchJob.dao.InformationDao;
import com.SeventhGroup.CollegeSearchJob.entity.CominformationEntity;
import com.SeventhGroup.CollegeSearchJob.entity.HistoryofEntity;
import com.SeventhGroup.CollegeSearchJob.entity.informationEntity;
import com.SeventhGroup.CollegeSearchJob.util.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HistoryService {
    @Resource
    CominformationDao cominformationDao;
    @Resource
    InformationDao informationDao;

    @Resource
    HistoryDao historyDao;

    public void insertHistory(String stuId, String comId,String type){
        String id = Util.getUniqueId();
        historyDao.save(new HistoryofEntity(id, stuId, comId, type));
    }

    public List<CominformationEntity> findChainForStu(String stuId, String type){
        List<HistoryofEntity> chain_1 = historyDao.findAllByUserIdAndType(stuId, type);

        List<HistoryofEntity> chain_2 = new ArrayList<>();

        for (HistoryofEntity entity : chain_1){
            List<HistoryofEntity> un_chain = historyDao.findAllByCompanyIdAndType(entity.getCompanyId(), type);
            for (HistoryofEntity entity_2 : un_chain){
                chain_2.add(entity_2);
            }
        }

        Map<String, Integer> map = new HashMap<>();
        for (HistoryofEntity entity : chain_2){
            map.put(entity.getCompanyId(), map.get(entity.getCompanyId())+1);
        }

        Integer MaxNum = 0;
        String NowComId = new String();
        List<String> ComIdlist = new ArrayList<>();
        Integer count = 0;
        while ( count <5 ){
            for(String key : map.keySet()){
                Integer now_num = map.get(key);
                if (now_num > MaxNum){
                    MaxNum = now_num;
                    NowComId = key;
                }
            }
            MaxNum = 0;
            ComIdlist.add(NowComId);
            map.remove(NowComId);
            count++;
        }

        List<CominformationEntity> recomList = cominformationDao.findAllById(ComIdlist);

        return  recomList;
    }

    public List<informationEntity> findChainForCom(String comId, String type){
        List<HistoryofEntity> chain_1 = historyDao.findAllByCompanyIdAndType(comId, type);

        List<HistoryofEntity> chain_2 = new ArrayList<>();

        for (HistoryofEntity entity : chain_1){
            List<HistoryofEntity> un_chain = historyDao.findAllByUserIdAndType(entity.getUserId(), type);
            for (HistoryofEntity entity_2 : un_chain){
                chain_2.add(entity_2);
            }
        }

        Map<String, Integer> map = new HashMap<>();
        for (HistoryofEntity entity : chain_2){
            map.put(entity.getUserId(), map.get(entity.getUserId())+1);
        }

        Integer MaxNum = 0;
        String NowStuId = new String();
        List<String> StuIdlist = new ArrayList<>();
        Integer count = 0;
        while ( count <5 ){
            for(String key : map.keySet()){
                Integer now_num = map.get(key);
                if (now_num > MaxNum){
                    MaxNum = now_num;
                    NowStuId = key;
                }
            }
            MaxNum = 0;
            StuIdlist.add(NowStuId);
            map.remove(NowStuId);
            count++;
        }

        List<informationEntity> recomList = informationDao.findAllById(StuIdlist);

        return  recomList;
    }






}
