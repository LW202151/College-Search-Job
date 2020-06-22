package com.SeventhGroup.CollegeSearchJob.service;


import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.dao.PicOfappDao;
import com.SeventhGroup.CollegeSearchJob.entity.PicOfappEntity;
import com.SeventhGroup.CollegeSearchJob.entity.PicOfcomEntity;
import com.SeventhGroup.CollegeSearchJob.util.COSUtil;
import com.SeventhGroup.CollegeSearchJob.util.Util;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class PicofappService {
@Resource
    PicOfappDao picOfappDao;
@Resource
SeeApplicationService seeApplicationService;

    /**
     * 上传作文图片
     * @param applicationId applicationId
     * @param fileInputStream 文件输入流
     * @param fileName 文件名
     */
    public void upload(String applicationId, InputStream fileInputStream, String fileName) throws SecondRuntimeException {
        List<PicOfappEntity> check =picOfappDao .findByApplicationId(applicationId);

        if (!seeApplicationService.checkGoodExist(applicationId)) {
            throw new SecondRuntimeException("招聘未发布，无法上传图片，请发布");
        }

        String fileType = Util.fromNameGetType(fileName);
        String key = Util.getUniqueId().substring(16) + "-" + Util.getNowTime() + "." + fileType;


        // upload
        try {
            COSUtil.uploadWithInputStream(fileInputStream, key);
        } catch (IOException e) {
            throw new RuntimeException("COS exception:" + e.getMessage());
        }

        picOfappDao.save(new PicOfappEntity( applicationId, key));
    }


    /**
     * 根据userId得到图片真实地址
     * @param application application
     * @return String
     */
    public String fromUserIdGetUrl(String application) {

        List<PicOfappEntity> temp = picOfappDao.findByApplicationId(application);

        if (temp.size() == 0) {
            return null;
        }

        return COSUtil.getUrlFromObjectKey(temp.get(0).getAppkey());
    }








}
