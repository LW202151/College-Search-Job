package com.SeventhGroup.CollegeSearchJob.service;


import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.dao.*;
import com.SeventhGroup.CollegeSearchJob.entity.*;
import com.SeventhGroup.CollegeSearchJob.service.inner.Resume;
import com.SeventhGroup.CollegeSearchJob.util.COSUtil;
import com.SeventhGroup.CollegeSearchJob.util.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResumeService {
    @Resource
    ResumeDao resumeDao;
    @Resource
    UserService userService;
    @Resource
    ResumeyesDao resumeyesDao;
    @Resource
    SendresumeDao sendresumeDao;
    @Resource
    AlreadyAccessOfcomDao userAlreadyAccessDao;

/*

    public String findresume(String resumeId) throws SecondRuntimeException {
        List<ResumeEntity> checkposition = resumeDao.findByResumeId(resumeId);
        if (checkposition.size() == 0) {
            throw new SecondRuntimeException("简历未上传，无法查看");
        }
        return checkposition.get(0).getResumeId();
    }

*/


    /**
     * 上传文件
     *
     * @param userId          userId
     * @param fileInputStream 文件输入流
     * @param fileName        文件名
     */
    public void upload(String userId, InputStream fileInputStream, String fileName) throws SecondRuntimeException {
        List<ResumeEntity> check = resumeDao.findByUserId(userId);
        // List<User> checkUserId = userDao.findByUserId(userId);

        if (!userService.checkUserIdExist(userId)) {
            throw new SecondRuntimeException("用户id不存在，无法上传简历，请注册");
        }

        String fileType = Util.fromNameGetType(fileName);
        String key = Util.getUniqueId().substring(16) + "-" + Util.getNowTime() + "." + fileType;


        // upload
        try {
            COSUtil.uploadWithInputStream(fileInputStream, key);
        } catch (IOException e) {
            throw new RuntimeException("COS exception:" + e.getMessage());
        }

        resumeDao.save(new ResumeEntity(Util.getUniqueId(), userId, Util.getNowTime(), key));
    }


    /**
     * 根据userId得到文件真实地址
     *
     * @param userId userId
     * @return String
     */
    public String fromUserIdGetUrl(String userId) {

        List<ResumeEntity> temp = resumeDao.findByUserId(userId);

        if (temp.size() == 0) {
            return null;
        }


        return COSUtil.getUrlFromObjectKey(temp.get(0).getRekey());
    }

    /**
     * 实体list换真实地址实体
     *
     * @param list list
     * @return List&ltI;nnerGood&gt;
     */
    public List<Resume> fromEntityListGetResumeList(List<ResumeEntity> list) {
        List<Resume> res = new ArrayList<>();
        for (ResumeEntity entity : list) {

            List<ResumeEntity> temp = resumeDao.findByResumeId(entity.getResumeId());
            String url = null;

            if (temp.size() == 0) {
                url = null;
            } else {
                url = COSUtil.getUrlFromObjectKey(temp.get(0).getRekey());

            }

            res.add(new Resume(entity, url));
        }

        return res;
    }

    public List<ResumeEntity> findAllByDate(String userId) throws SecondRuntimeException{
        List<ResumeEntity> list = resumeDao.findByUserId(userId);
        if (!userService.checkUserIdExist(userId)) {
            throw new SecondRuntimeException("用户id不存在，无法查看简历箱，请注册");
        }

        list.sort((o1, o2) -> Util.compareDateFromString(o1.getRetime(), o2.getRetime()));

        return list;
    }

    @Transactional
    public void under(String resumeId) throws SecondRuntimeException {


        List<ResumeEntity> temp = resumeDao.findByResumeId(resumeId);

        if (temp.size() == 0) {
            throw new SecondRuntimeException("简历不存在,无法进行删除");
        }

        resumeDao.deleteByResumeId(resumeId);

    }


}







