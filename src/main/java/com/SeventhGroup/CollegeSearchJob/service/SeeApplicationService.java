package com.SeventhGroup.CollegeSearchJob.service;


import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.dao.*;
import com.SeventhGroup.CollegeSearchJob.entity.*;
import com.SeventhGroup.CollegeSearchJob.service.inner.PicOfapp;
import com.SeventhGroup.CollegeSearchJob.util.COSUtil;
import com.SeventhGroup.CollegeSearchJob.util.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeeApplicationService {
    @Resource
    SearchDao searchDao;
    @Resource
    CompanyService companyService;
    @Resource
    AppOfcomDao appOfcomDao;
    @Resource
    PicOfappDao picOfappDao;
    @Resource
    SendresumeDao sendresumeDao;
    @Resource
    UserService userService;
    @Resource
    InformationDao informationDao;
    @Resource
    PicUserDao picUserDao;
    @Resource
    UserinfoDao userinfoDao;
    @Resource
    CommentDao commentDao;
    @Resource
    CominfoDao cominfoDao;
    @Resource
    PicOfcomDao picOfcomDao;
    @Resource
    CominformationDao cominformationDao;
    @Resource
    UserDao userDao;
    @Resource
    CompanyDao companyDao;
    @Resource
    ResumeOfthreeDao resumeOfthreeDao;
    @Resource
    UserAccessyesDao userAccessyesDao;
    @Resource
    AlreadyAccessOfuserDao alreadyAccessOfuserDao;
    @Resource
    AlreadyAccessOfcomDao alreadyAccessOfcomDao;

    public boolean checkGoodExist(String applicationId) {
        return searchDao.findByApplicationId(applicationId).size() != 0;
    }

    public String postGood(String comName, String companydesc, String position, String positiondesc, String requirement, Integer num, String money, String address, String tag,String companyId) throws SecondRuntimeException {
       List<ApplicationEntity> temp = searchDao.findByPosition(position);
       // List<ApplicationEntity> checktemp = searchDao.findByCompanyId(companyId);


        if (!companyService.checkUserIdExist(companyId)) {
            throw new SecondRuntimeException("公司id不存在，无法发布招聘，请注册");
        }

        if (temp.size()==1) {
            throw new SecondRuntimeException("该岗位的招聘已发布");
        }
        String applicationId = Util.getUniqueId();

        searchDao.save(new ApplicationEntity(applicationId, comName, companydesc, position, positiondesc, requirement, num, money, address, tag, Util.getNowTime()));
        appOfcomDao.save(new AppOfcomEntity(applicationId, companyId));
        return applicationId;
    }

    public List<ApplicationEntity> findAllByDate() {
        List<ApplicationEntity> list = searchDao.findAll();

        list.sort((o1, o2) -> Util.compareDateFromString(o1.getUptime(), o2.getUptime()));

        return list;
    }

    public String findByName(String comName) throws SecondRuntimeException {
        List<ApplicationEntity> checkname = searchDao.findByComName(comName);
        if (checkname.size() == 0) {
            throw new SecondRuntimeException("该公司未发布招聘");
        }
        return checkname.get(0).getApplicationId();
    }



    public String findAllPosition(String position) throws SecondRuntimeException {
        List<ApplicationEntity> checkposition = searchDao.findByPosition(position);
        if (checkposition.size() == 0) {
            throw new SecondRuntimeException("有关职位的招聘未发布");
        }
        return checkposition.get(0).getApplicationId();
    }

    public String findAllApplicationId(String applicationId) throws SecondRuntimeException {
        List<ApplicationEntity> checkId = searchDao.findByApplicationId(applicationId);
        if (checkId.size() == 0) {
            throw new SecondRuntimeException("该招聘未存在");
        }

        return checkId.get(0).getApplicationId();
    }
    public String findAllTag(String tag) throws SecondRuntimeException {
        List<ApplicationEntity> checkId = searchDao.findByTag(tag);
        if (checkId.size() == 0) {
            throw new SecondRuntimeException("该类型的招聘未发布");
        }

        return checkId.get(0).getApplicationId();
    }

    public String findcomanyid(String applicationId) throws SecondRuntimeException {
        List<AppOfcomEntity> checkId = appOfcomDao.findByApplicationId(applicationId);
        if (checkId.size() == 0) {
            throw new SecondRuntimeException("公司未发布相应的招聘");
        }
        return checkId.get(0).getApplicationId();
    }


    public List<ApplicationEntity> getComApp(String companyId) throws SecondRuntimeException{

        List<AppOfcomEntity> temp = appOfcomDao.findByCompanyId(companyId);

        List<ApplicationEntity> result = new ArrayList<>();
        if(temp.size()==0){
            throw new SecondRuntimeException("公司id未发布招聘，无法获得公司发布的招聘");
        }

        for (AppOfcomEntity entity : temp) {
            String applicationgId = entity.getApplicationId();

            ApplicationEntity real = searchDao.findByApplicationId(applicationgId).get(0);

           result.add(real);
            //return real;
        }

        return result;
    }


    public void getremoveApp(String companyId) throws SecondRuntimeException{

        List<AppOfcomEntity> temp = appOfcomDao.findByCompanyId(companyId);

        List<ApplicationEntity> result = new ArrayList<>();
        if(temp.size()==0){
            throw new SecondRuntimeException("公司id不存在，无法进行删除");
        }

        for (AppOfcomEntity entity : temp) {
            String applicationgId = entity.getApplicationId();

            //ApplicationEntity real = searchDao.findByApplicationId(applicationgId).get(0);
            searchDao.deleteByApplicationId(applicationgId);
            //result.remove(real);
            //return real;
        }

       // return result;
    }




    /**
     * 删除招聘
     * @param applicationId
     * @throws SecondRuntimeException
     */
    @Transactional
    public void underapplication(String applicationId) throws SecondRuntimeException {


            List<AppOfcomEntity> temp = appOfcomDao.findByApplicationId(applicationId);

            if (temp.size() == 0) {
                throw new SecondRuntimeException("招聘Id不存在,无法进行删除");
            }

            searchDao.deleteByApplicationId(applicationId);
            appOfcomDao.deleteByApplicationId(applicationId);
        sendresumeDao.deleteByApplicationId(applicationId);
        picOfappDao.deleteByApplicationId(applicationId);
        commentDao.deleteByApplicationId(applicationId);
        resumeOfthreeDao.deleteByApplicationId(applicationId);



    }
    /**
     * 删除用户
     * @param userId
     * @throws SecondRuntimeException
     */
    @Transactional
    public void underuser(String userId) throws SecondRuntimeException {


       /* List<AppOfcomEntity> temp = appOfcomDao.findByApplicationId(userId);

        if (temp.size() == 0) {
            throw new SecondRuntimeException("招聘不存在,无法进行删除");
        }
*/
        if (!userService.checkUserIdExist(userId)) {
            throw new SecondRuntimeException("用户id不存在，无法进行删除");
        }
        userinfoDao.deleteByUserId(userId);
        informationDao.deleteByUserId(userId);
        picUserDao.deleteByUserId(userId);
        sendresumeDao.deleteByUserId(userId);
        commentDao.deleteByUserId(userId);
        userDao.deleteById(userId);
        resumeOfthreeDao.deleteByUserId(userId);
        userAccessyesDao.deleteByUserId(userId);
        alreadyAccessOfuserDao.deleteByUserId(userId);
        resumeOfthreeDao.deleteByUserId(userId);

    }


    /**
     * 删除公司
     * @param companyId
     * @throws SecondRuntimeException
     */
    @Transactional
    public void undercompany(String companyId) throws SecondRuntimeException {


       /* List<AppOfcomEntity> temp = appOfcomDao.findByApplicationId(userId);

        if (temp.size() == 0) {
            throw new SecondRuntimeException("招聘不存在,无法进行删除");
        }
*/
        if (!companyService.checkUserIdExist(companyId)) {
            throw new SecondRuntimeException("公司id不存在，无法进行删除");
        }
        appOfcomDao.deleteByCompanyId(companyId);
        picOfcomDao.deleteByCompanyId(companyId);
        cominfoDao.deleteByCompanyId(companyId);
        sendresumeDao.deleteByCompanyId(companyId);
        commentDao.deleteByCompanyId(companyId);
        cominformationDao.deleteByCompanyId(companyId);
        companyDao.deleteById(companyId);
        resumeOfthreeDao.deleteByCompanyId(companyId);
        alreadyAccessOfcomDao.deleteByCompanyId(companyId);

    }

    /**
     * 实体list换真实地址实体
     * @param list list
     * @return List&ltI;nnerGood&gt;
     */
    public List<PicOfapp> fromEntityListGetPicappList(List<ApplicationEntity> list) {
        List<PicOfapp> res = new ArrayList<>();
        // List<informationEntity> check = informationdao.findByUserId(userId);
        for (ApplicationEntity entity : list) {
            List<PicOfappEntity> temp = picOfappDao.findByApplicationId(entity.getApplicationId());
            String url = null;

            if (temp.size() == 0) {
                url = null;
            }

            else {
                url = COSUtil.getUrlFromObjectKey(temp.get(0).getAppkey());
                //  res.add(new PicOfuser(entity,url));
            }

            res.add(new PicOfapp(entity,url));
        }

        return res;
    }


}