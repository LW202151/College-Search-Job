package com.SeventhGroup.CollegeSearchJob.service;

import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.dao.PicUserDao;
import com.SeventhGroup.CollegeSearchJob.entity.PicUserEntity;
import com.SeventhGroup.CollegeSearchJob.util.COSUtil;
import com.SeventhGroup.CollegeSearchJob.util.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class PicUserService {
    @Resource
    PicUserDao picUserDao;
    @Resource
    UserService userService;

    /**
     * 上传图片
     * @param userId userId
     * @param fileInputStream 文件输入流
     * @param fileName 文件名
     */
    public void upload(String userId, InputStream fileInputStream, String fileName) throws SecondRuntimeException {
        List<PicUserEntity> check = picUserDao.findByUserId(userId);

        if (!userService.checkUserIdExist(userId)) {
            throw new SecondRuntimeException("用户id不存在，无法上传图片，请注册");
        }

        String fileType = Util.fromNameGetType(fileName);
        String key = Util.getUniqueId().substring(16) + "-" + Util.getNowTime() + "." + fileType;


        // upload
        try {
            COSUtil.uploadWithInputStream(fileInputStream, key);
        } catch (IOException e) {
            throw new RuntimeException("COS exception:" + e.getMessage());
        }

        picUserDao.save(new PicUserEntity( userId, key));
    }


    /**
     * 根据userId得到图片真实地址
     * @param userId userId
     * @return String
     */
    public String fromUserIdGetUrl(String userId) {

        List<PicUserEntity> temp = picUserDao.findByUserId(userId);

        if (temp.size() == 0) {
            return null;
        }

        return COSUtil.getUrlFromObjectKey(temp.get(0).getPickey());
    }


}


