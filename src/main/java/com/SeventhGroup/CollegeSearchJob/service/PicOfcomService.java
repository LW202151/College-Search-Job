package com.SeventhGroup.CollegeSearchJob.service;

import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.dao.PicOfcomDao;
import com.SeventhGroup.CollegeSearchJob.entity.PicOfcomEntity;
import com.SeventhGroup.CollegeSearchJob.entity.PicUserEntity;
import com.SeventhGroup.CollegeSearchJob.service.inner.PicOfcom;
import com.SeventhGroup.CollegeSearchJob.util.COSUtil;
import com.SeventhGroup.CollegeSearchJob.util.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class PicOfcomService {
@Resource
    PicOfcomDao picOfcomDao;
@Resource
CompanyService companyService;
    /**
     * 上传作文图片
     * @param companyId companyId
     * @param fileInputStream 文件输入流
     * @param fileName 文件名
     */
    public void upload(String companyId, InputStream fileInputStream, String fileName) throws SecondRuntimeException {
        List<PicOfcomEntity> check = picOfcomDao.findByCompanyId(companyId);

        if (!companyService.checkUserIdExist(companyId)) {
            throw new SecondRuntimeException("公司id不存在，无法上传图片，请注册");
        }

        String fileType = Util.fromNameGetType(fileName);
        String key = Util.getUniqueId().substring(16) + "-" + Util.getNowTime() + "." + fileType;


        // upload
        try {
            COSUtil.uploadWithInputStream(fileInputStream, key);
        } catch (IOException e) {
            throw new RuntimeException("COS exception:" + e.getMessage());
        }

        picOfcomDao.save(new PicOfcomEntity( companyId, key));
    }


    /**
     * 根据userId得到图片真实地址
     * @param companyId companyId
     * @return String
     */
    public String fromUserIdGetUrl(String companyId) {

        List<PicOfcomEntity> temp = picOfcomDao.findByCompanyId(companyId);

        if (temp.size() == 0) {
            return null;
        }

        return COSUtil.getUrlFromObjectKey(temp.get(0).getPicOfkey());
    }








}
