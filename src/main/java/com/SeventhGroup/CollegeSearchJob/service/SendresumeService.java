package com.SeventhGroup.CollegeSearchJob.service;


import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.dao.*;
import com.SeventhGroup.CollegeSearchJob.entity.*;
import com.SeventhGroup.CollegeSearchJob.service.inner.ResumeOfthree;
import com.SeventhGroup.CollegeSearchJob.service.inner.Sendresume;
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
public class SendresumeService {
   @Resource
   SendresumeDao sendresumeDao;

    @Resource
    UserService userService;
    @Resource
    AppOfcomDao appOfcomDao;

    @Resource
    ResumeyesDao resumeyesDao;
    @Resource
    CompanyService companyService;
    @Resource
    AlreadyAccessOfuserDao userAlreadyAccessDao;
    @Resource
    AlreadyAccessOfcomDao comAlreadyAccessDao;
    @Resource
    ResumeOfthreeDao resumeOfthreeDao;
    @Resource
    SaveresumeAccessDao saveresumeAccessDao;
    @Resource
    UserAccessyesDao userAccessyesDao;

    /**
     * 上传文件
     *
     * @param userId          userId
     * @param fileInputStream 文件输入流
     * @param fileName        文件名
     */
    public void upload(String userId,String companyId,String applicationId ,InputStream fileInputStream, String fileName) throws SecondRuntimeException {
        // List<SendresumeEntity> check = sendresumeDao.findByUserId(userId);
        List<ResumeOfthreeEntity> checkapp = resumeOfthreeDao.findByUserIdAndApplicationId(userId, applicationId);
        List<AppOfcomEntity> checkOfapp = appOfcomDao.findByApplicationId(applicationId);
        List<AppOfcomEntity> checkcom = appOfcomDao.findByCompanyId(companyId);
        List<AppOfcomEntity> checkcomAndapp = appOfcomDao.findByCompanyIdAndApplicationId(companyId, applicationId);
        List<ResumeOfthreeEntity> check = resumeOfthreeDao.findByUserIdAndCompanyId(userId, companyId);
        if (!userService.checkUserIdExist(userId)) {
            throw new SecondRuntimeException("用户id不存在，无法投递简历，请注册");
        }
        if (checkapp.size() > 0 || check.size() > 0) {
            throw new SecondRuntimeException("已投递");
        }
        if (checkOfapp.size() == 0) {
            throw new SecondRuntimeException("招聘未发布");
        }
        if (checkcom.size() == 0) {
            throw new SecondRuntimeException("公司未注册");
        }
        if (checkcomAndapp.size() == 0) {
            throw new SecondRuntimeException("公司和招聘不匹配");
        }

        String fileType = Util.fromNameGetType(fileName);
        String key = Util.getUniqueId().substring(16) + "-" + Util.getNowTime() + "." + fileType;


        // upload
        try {
            COSUtil.uploadWithInputStream(fileInputStream, key);
        } catch (IOException e) {
            throw new RuntimeException("COS exception:" + e.getMessage());
        }
        String resumeId =Util.getUniqueId();
        sendresumeDao.save(new SendresumeEntity(Util.getUniqueId(), userId, resumeId, companyId, applicationId, Util.getNowTime(), key));
        resumeOfthreeDao.save(new ResumeOfthreeEntity(Util.getUniqueId(),userId, companyId,applicationId,resumeId, key));

    }

    /**
     * 根据userId得到文件真实地址
     *
     * @param userId userId
     * @return String
     */
    public String fromUserIdGetUrl(String userId) {

        List<SendresumeEntity> temp = sendresumeDao.findByUserId(userId);

        if (temp.size() == 0) {
            return null;
        }


        return COSUtil.getUrlFromObjectKey(temp.get(0).getSendkey());
    }


    public String fromUserIdGetUrl1(String userId) {

        List<ResumeOfthreeEntity> temp = resumeOfthreeDao.findByUserId(userId);

        if (temp.size() == 0) {
            return null;
        }


        return COSUtil.getUrlFromObjectKey(temp.get(0).getThreekey());
    }
    /**
     * 实体list换真实地址实体
     *
     * @param list list
     * @return List&ltI;nnerGood&gt;
     */
    public List<Sendresume> fromEntityListGetResumeList(List<SendresumeEntity> list) {
        List<Sendresume> res = new ArrayList<>();
        for (SendresumeEntity entity : list) {

            List<SendresumeEntity> temp = sendresumeDao.findByResumeId(entity.getResumeId());
            String url = null;

            if (temp.size() == 0) {
                url = null;
            } else {
                url = COSUtil.getUrlFromObjectKey(temp.get(0).getSendkey());

            }

            res.add(new Sendresume(entity, url));
        }

        return res;
    }


    public List<ResumeOfthree> fromEntityGetResumeThreeList(List<ResumeOfthreeEntity> list) {
        List<ResumeOfthree> res = new ArrayList<>();
        //List<ResumeOfthreeEntity> check = resumeOfthreeDao.findByResumeId(String resumeId);
        for (ResumeOfthreeEntity entity : list) {

            List<ResumeOfthreeEntity> temp = resumeOfthreeDao.findByResumeId(entity.getResumeId());
            String url = null;

            if (temp.size() == 0) {
                url = null;
            } else {
                url = COSUtil.getUrlFromObjectKey(temp.get(0).getThreekey());

            }

            res.add(new ResumeOfthree(entity, url));
        }

        return res;
    }








    public List<SendresumeEntity> findAllByDate(String userId) throws SecondRuntimeException{
        List<SendresumeEntity> list = sendresumeDao.findByUserId(userId);
        if (!userService.checkUserIdExist(userId)) {
            throw new SecondRuntimeException("用户id不存在，，无法查看已投递的简历");
        }

        list.sort((o1, o2) -> Util.compareDateFromString(o1.getSendtime(), o2.getSendtime()));

        return list;
    }

    public List<SendresumeEntity> findByDate(String companyId) throws SecondRuntimeException{
        List<SendresumeEntity> list = sendresumeDao.findByCompanyId(companyId);
        if (list.size()==0) {
            throw new SecondRuntimeException("公司id不存在，，无法查看已接收的简历");
        }

        list.sort((o1, o2) -> Util.compareDateFromString(o1.getSendtime(), o2.getSendtime()));

        return list;
    }


    public List<SendresumeEntity> findBy(String companyId,String applicationId) throws SecondRuntimeException{
        List<SendresumeEntity> list = sendresumeDao.findByCompanyIdAndApplicationId(companyId,applicationId);
        if (list.size()==0) {
            throw new SecondRuntimeException("招聘未发布不存在，，学生无法投递简历");
        }

        list.sort((o1, o2) -> Util.compareDateFromString(o1.getSendtime(), o2.getSendtime()));

        return list;
    }




    public String findsendresume(String resumeId) throws SecondRuntimeException {
        List<SendresumeEntity> checkposition = sendresumeDao.findByResumeId(resumeId);
        if (checkposition.size() == 0) {
            throw new SecondRuntimeException("简历未投递，无法查看");
        }
        return checkposition.get(0).getResumeId();
    }

    @Transactional
    public void buy(String companyId, String resumeId) throws SecondRuntimeException {

            List<SendresumeEntity> temp = sendresumeDao.findByResumeId(resumeId);

            if (temp.size() == 0) {
                throw new SecondRuntimeException("简历id不存在，无法审核");
            }

            if (!companyService.checkUserIdExist(companyId)) {
                throw new SecondRuntimeException("公司id不存在，无法审核");
            }

            // buyer存起来
            userAlreadyAccessDao.save(new UserAlreadyAccessEntity(Util.geFulltUniqueId(), resumeId, temp.get(0).getUserId()));

            // poster存起来
            comAlreadyAccessDao.save(new ComAlrealdyAccessEntity(Util.geFulltUniqueId(), resumeId, companyId));
            //saveresumeAccessDao.save(new ComAlrealdyAccessEntity(Util.geFulltUniqueId(), resumeId, companyId));

        // 购物车中删除这个商品
            sendresumeDao.deleteByResumeId(resumeId);


    }

    /**
     * 获取所有已经买过的Good（公司获得已审核的简历）
     * @param companyId companyId
     * @return List
     */
    public List<SendresumeEntity> getComAlreadyAccess(String companyId) {

        List<ComAlrealdyAccessEntity> temp = comAlreadyAccessDao.findByCompanyId(companyId);

        List<SendresumeEntity> result = new ArrayList<>();

        for (ComAlrealdyAccessEntity entity : temp) {
            String resumeId = entity.getResumeId();
            if (resumeId != null) {
                SendresumeEntity real = sendresumeDao.findByResumeId(resumeId).get(0);

                result.add(real);
            }
        }
        return result;
    }

    /**
     * 获取所有已经卖过的Good（学生获得已审核的简历）
     * @param userId userId
     * @return List
     */
    public List<SendresumeEntity> getUserAlreadyAccess(String userId) {

        List<UserAlreadyAccessEntity> temp = userAlreadyAccessDao.findByUserId(userId);

        List<SendresumeEntity> result = new ArrayList<>();

        for (UserAlreadyAccessEntity entity : temp) {
            String resumeId = entity.getResumeId();
            if (resumeId != null) {
                SendresumeEntity real = sendresumeDao.findByResumeId(resumeId).get(0);

                result.add(real);
            }
        }
        return result;
    }


    /**
     * 发布简历审核结果
     * 通过状态
     */
    @Transactional
    public void Yes(String companyId, String resumeId) throws SecondRuntimeException {

        List<ResumeOfthreeEntity> temp = resumeOfthreeDao.findByResumeId(resumeId);

        if (temp.size() == 0) {
            throw new SecondRuntimeException("简历id不存在，无法审核");
        }

        if (!companyService.checkUserIdExist(companyId)) {
            throw new SecondRuntimeException("公司id不存在，无法审核");
        }

        // buyer存起来
        userAccessyesDao.save(new UserAccessyesEntity(Util.geFulltUniqueId(), resumeId, temp.get(0).getUserId()));

        // poster存起来
       // comAlreadyAccessDao.save(new ComAlrealdyAccessEntity(Util.geFulltUniqueId(), resumeId, companyId));
        //saveresumeAccessDao.save(new ComAlrealdyAccessEntity(Util.geFulltUniqueId(), resumeId, companyId));

        // 购物车中删除这个商品
        userAlreadyAccessDao.deleteByResumeId(resumeId);


    }








}
