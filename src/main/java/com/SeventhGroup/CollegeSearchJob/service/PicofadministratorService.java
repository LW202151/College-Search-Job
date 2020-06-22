package com.SeventhGroup.CollegeSearchJob.service;

import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.dao.PicOfadDao;
import com.SeventhGroup.CollegeSearchJob.entity.AdministratorEntity;
import com.SeventhGroup.CollegeSearchJob.entity.PicOfappEntity;
import com.SeventhGroup.CollegeSearchJob.entity.PicofadministratorEntity;
import com.SeventhGroup.CollegeSearchJob.util.COSUtil;
import com.SeventhGroup.CollegeSearchJob.util.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class PicofadministratorService {
@Resource
    PicOfadDao picOfadDao;
@Resource
AdministratorService administratorService;
    /**
     * 上传作文图片
     * @param administratorId administratorId
     * @param fileInputStream 文件输入流
     * @param fileName 文件名
     */
    public void upload(String administratorId, InputStream fileInputStream, String fileName) throws SecondRuntimeException {
        /*List<AdministratorEntity> check =picOfadDao .findByAdministratorId(administratorId);

        if (check.size()==0) {
            throw new SecondRuntimeException("管理员Id出错，无法上传图片");
        }
*/

        if (!administratorService.checkUserIdExist(administratorId)) {
            throw new SecondRuntimeException("管理员Id出错，无法上传图片");
        }
        String fileType = Util.fromNameGetType(fileName);
        String key = Util.getUniqueId().substring(16) + "-" + Util.getNowTime() + "." + fileType;


        // upload
        try {
            COSUtil.uploadWithInputStream(fileInputStream, key);
        } catch (IOException e) {
            throw new RuntimeException("COS exception:" + e.getMessage());
        }

        picOfadDao.save(new PicofadministratorEntity( administratorId, key));
    }


    /**
     * 根据userId得到图片真实地址
     * @param administratorId administratorId
     * @return String
     */
    public String fromUserIdGetUrl(String administratorId ) {

        List<PicofadministratorEntity> temp = picOfadDao.findByAdministratorId(administratorId);

        if (temp.size() == 0) {
            return null;
        }

        return COSUtil.getUrlFromObjectKey(temp.get(0).getAdkey());
    }



}
