package com.SeventhGroup.CollegeSearchJob.service;


import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.dao.InformationDao;
import com.SeventhGroup.CollegeSearchJob.dao.PicUserDao;
import com.SeventhGroup.CollegeSearchJob.dao.UserDao;
import com.SeventhGroup.CollegeSearchJob.dao.UserinfoDao;
import com.SeventhGroup.CollegeSearchJob.entity.*;
import com.SeventhGroup.CollegeSearchJob.service.inner.InformationContent;
import com.SeventhGroup.CollegeSearchJob.service.inner.PicOfuser;
import com.SeventhGroup.CollegeSearchJob.util.COSUtil;
import com.SeventhGroup.CollegeSearchJob.util.Util;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Service
public class InformationService {
  @Resource
  InformationDao informationdao;

  @Resource
  UserinfoDao userinfodao;

  @Resource
  UserService userservice;

  @Resource
  UserDao userdao;
  @Resource
    PicUserDao picUserDao;
    public  boolean checkUserIdExist(String userId) {
        return userdao.findById(userId).isPresent();
    }

  public void postInformation(String userId, List<InformationContent> info) throws SecondRuntimeException{
     // List<UserinfoEntity> t = userinfodao.findByUserid(userId);
      if (!userservice.checkUserIdExist(userId)) {
          throw new SecondRuntimeException("用户id不存在，无法修改个人信息，请注册");
      }
      /*
      覆盖个人信息
       */
      //User userop =userdao.findById(userId).get();
     // userop.setName(email);
      //userop.setEmail(name);
      //userdao.save(userop);

      /*
      覆盖information body
       */
      List<UserinfoEntity> curr = userinfodao.findByuserId(userId);
      List<informationEntity> currList = new ArrayList<>();

      for (UserinfoEntity entity : curr) {
          currList.add(informationdao.findById(entity.getInfoId()).get());
      }

      for (InformationContent content : info) {
          if (content == null) {
              continue;
          }

          this.fromIndexUpdateNew(currList, content, userId);
      }

  }

    private void fromIndexUpdateNew(List<informationEntity> currList, InformationContent newContent, String userId) {


        for (informationEntity entity : currList) {

            entity.setSex(newContent.getSex());
            entity.setRealname(newContent.getRealname());
            entity.setBirthdate(newContent.getBirthdate());
            entity.setSchool(newContent.getSchool());
            entity.setEducation(newContent.getEducation());
           // entity.setEducation(newContent.getEducation());
            entity.setProfessional(newContent.getProfessional());
            entity.setGraduatetime(newContent.getGraduatetime());
            entity.setExperience(newContent.getExperience());
            entity.setWork(newContent.getWork());
            entity.setWorkaddress(newContent.getWorkaddress());


            informationdao.save(entity);

                return;

        }

        String infoId = Util.geFulltUniqueId();
        //String userId =  userservice.register(email,name,password);

        informationdao.save(new informationEntity(infoId,
                newContent.getSex(),
                newContent.getRealname(),
                newContent.getBirthdate(),
                newContent.getSchool(),
                newContent.getEducation(),
                //newContent.getEducation()
                newContent.getProfessional(),
                newContent.getGraduatetime(),
                newContent.getExperience(),
                newContent.getWork(),
                newContent.getWorkaddress(),
               userId));
               // newContent.getIndex()));
        userinfodao.save(new UserinfoEntity(Util.geFulltUniqueId(), userId, infoId));
    }
    /**
     * 实体list换真实地址实体
     * @param list list
     * @return List&ltI;nnerGood&gt;
     */
    public List<PicOfuser> fromEntityListGetPicUserList(List<informationEntity> list) {
        List<PicOfuser> res = new ArrayList<>();
       // List<informationEntity> check = informationdao.findByUserId(userId);
        for (informationEntity entity : list) {
            List<PicUserEntity> temp = picUserDao.findByUserId(entity.getUserId());
            String url = null;

            if (temp.size() == 0) {
                url = null;
            }

            else {
                url = COSUtil.getUrlFromObjectKey(temp.get(0).getPickey());
              //  res.add(new PicOfuser(entity,url));
            }

        res.add(new PicOfuser(entity,url));
        }

        return res;
    }





}





