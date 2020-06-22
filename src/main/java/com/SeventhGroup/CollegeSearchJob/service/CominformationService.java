package com.SeventhGroup.CollegeSearchJob.service;

import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.dao.*;
import com.SeventhGroup.CollegeSearchJob.entity.*;
import com.SeventhGroup.CollegeSearchJob.service.inner.CominformationContent;
import com.SeventhGroup.CollegeSearchJob.service.inner.InformationContent;
import com.SeventhGroup.CollegeSearchJob.service.inner.PicOfcom;
import com.SeventhGroup.CollegeSearchJob.service.inner.PicOfuser;
import com.SeventhGroup.CollegeSearchJob.util.COSUtil;
import com.SeventhGroup.CollegeSearchJob.util.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CominformationService {

    @Resource
    CominformationDao cominformationdao;

    @Resource
    CominfoDao cominfodao;

    @Resource
    CompanyService companyservice;

    @Resource
    CompanyDao companydao;
    @Resource
    PicOfcomDao picOfcomDao;
    public  boolean checkUserIdExist(String companyId) {
        return companydao.findById(companyId).isPresent();
    }

    public void postInformation(String companyId, List<CominformationContent> cominfo) throws SecondRuntimeException {
        // List<UserinfoEntity> t = userinfodao.findByUserid(userId);
        if (!companyservice.checkUserIdExist(companyId)) {
            throw new SecondRuntimeException("公司id不存在，无法修改个人信息，请注册");
        }
      /*
      覆盖个人信息
       */
       // CompanyService userop =companydao.findById(userId).get();
        // userop.setName(email);
        //userop.setEmail(name);
        //userdao.save(userop);

      /*
      覆盖information body
       */
        List<CominfoEntity> curr = cominfodao.findBycompanyId(companyId);;
        List<CominformationEntity> currList = new ArrayList<>();

        for (CominfoEntity entity : curr) {
            currList.add(cominformationdao.findById(entity.getCominfoId()).get());
        }

        for (CominformationContent content : cominfo) {
            if (content == null) {
                continue;
            }

            this.fromIndexUpdateNew(currList, content, companyId);
        }

    }

    private void fromIndexUpdateNew(List<CominformationEntity> currList, CominformationContent newContent, String companyId) {


        for (CominformationEntity entity : currList) {

            entity.setCompanyName(newContent.getCompanyName());
            entity.setNature(newContent.getNature());
            entity.setComTime(newContent.getComTime());
            entity.setDescription(newContent.getDescription());
            entity.setAddress(newContent.getAddress());
            // entity.setEducation(newContent.getEducation());
            entity.setWeb(newContent.getWeb());
            entity.setMailbox(newContent.getMailbox());
            cominformationdao.save(entity);

            return;

        }

        String cominfoId = Util.geFulltUniqueId();

        cominformationdao.save(new CominformationEntity(cominfoId,
                newContent.getAddress(),
                newContent.getNature(),
                newContent.getComTime(),
                newContent.getDescription(),
                newContent.getAddress(),
                newContent.getWeb(),
                newContent.getMailbox(),
                companyId));
        // newContent.getIndex()));

        cominfodao.save(new CominfoEntity(Util.geFulltUniqueId(), companyId, cominfoId));
    }
    /**
     * 实体list换真实地址实体
     * @param list list
     * @return List&ltI;nnerGood&gt;
     */
    public List<PicOfcom> fromEntityListGetPicofcomList(List<CominformationEntity> list) {
        List<PicOfcom> res = new ArrayList<>();
        for (CominformationEntity entity : list) {

            List<PicOfcomEntity> temp = picOfcomDao.findByCompanyId(entity.getCompanyId());
            String url = null;

            if (temp.size() == 0) {
                url = null;
            }
            else {
                url = COSUtil.getUrlFromObjectKey(temp.get(0).getPicOfkey());
            }

            res.add(new PicOfcom(entity,url));
        }

        return res;
    }




}
