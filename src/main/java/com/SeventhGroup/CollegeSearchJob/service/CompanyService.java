package com.SeventhGroup.CollegeSearchJob.service;


import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.dao.*;
import com.SeventhGroup.CollegeSearchJob.entity.*;
import com.SeventhGroup.CollegeSearchJob.service.inner.CominfoContent;
import com.SeventhGroup.CollegeSearchJob.util.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    @Resource
    CompanyDao companyDao;
    @Resource
    CominfoDao cominfodao;
    @Resource
    CominformationDao cominformationDao;
    @Resource
    ComofemailDao comofemailDao;
    @Resource
    CheckcodeDao checkcodeDao;

    public  boolean checkUserIdExist(String companyId) {
        return companyDao.findById(companyId).isPresent();
    }
    public String register (String companyEmail,String comName,String comPassword) throws SecondRuntimeException {
        String companyId = Util.getUniqueId();

        List<CompanyEntity> checkcomEmail = companyDao.findByCompanyEmail(companyEmail);
        List<CompanyEntity> checkcomName = companyDao.findByComName(comName);
        List<CompanyEntity> checkcomPassword = companyDao.findByComPassword(comPassword);
        List<CheckcodeEntity> checkcodeOfcom = checkcodeDao.findByCode(comName);

       // List<User> checkEmail = userdao.findByEmail(companyEmail);
        if (checkcomEmail.size() > 0) {
            throw  new SecondRuntimeException("该用户已注册");
        }
        if (checkcomName.size() > 0) {
            throw  new SecondRuntimeException("该验证码已被使用过");
        }
        if (checkcodeOfcom.size() == 0) {
            throw  new SecondRuntimeException("验证码错误");
        }
        if (checkcomPassword.size() > 0) {
            throw  new SecondRuntimeException("该密码已经被使用过,请重新输入");
        }
        companyDao.save(new CompanyEntity(companyId, companyEmail, comName,comPassword));
        comofemailDao.save(new ComofemailEntity(companyId,companyEmail));
        return companyId;

    }
    public String getemail(String companyId){
        List<ComofemailEntity> temp = comofemailDao.findByCompanyId(companyId);
        return  temp.get(0).getCompanyEmail();

    }




    public String login(String companyEmail,String comPassword){
        List<CompanyEntity> checkEmail = companyDao.findByCompanyEmail(companyEmail);
        List<CompanyEntity> checkPassword = companyDao.findByComPassword(comPassword);
        List<CompanyEntity> check = companyDao.findByCompanyEmailAndComPassword(companyEmail,comPassword);;
        if (checkEmail.size() > 0 && checkPassword.size()==0) {
            throw  new SecondRuntimeException("密码错误");
        }
        if (checkEmail.size() == 0 && checkPassword.size() > 0) {
            throw  new SecondRuntimeException("账号错误");
        }
        if (checkEmail.size() ==0 && checkPassword.size()==0) {
            throw  new SecondRuntimeException("该用户尚未注册，请注册");
        }

        return check.get(0).getId();

    }
    /*
      修改密码
       */
    public String changePassword(String companyId, String companyEmail,String code,String comPassword) {
        List<CompanyEntity> checkEmail = companyDao.findByCompanyEmail(companyEmail);
        List<CheckcodeEntity> checkcodeOfpassword = checkcodeDao.findByCode(code);

        if (checkEmail.size() == 0) {
            throw new SecondRuntimeException("该用户不存在，无法修改密码");
        }
        if (checkcodeOfpassword.size() == 0) {
            throw new SecondRuntimeException("验证码错误");
        }
        CompanyEntity userop = companyDao.findById(companyId).get();
        userop.setComPassword(comPassword);
        companyDao.save(userop);
        return comPassword;

    }

    /**
     * 获取个人信息
     * @param companyId companyId
     * @return InfoContent
     *
     */
    public CominfoContent getInfo(String companyId) throws SecondRuntimeException{
        List<CominformationEntity> cominformation = new ArrayList<>();
        List<CominfoEntity> t = cominfodao.findBycompanyId(companyId);

        if (!this.checkUserIdExist(companyId)) {
            throw new SecondRuntimeException("用户id不存在，无法查看个人信息，请注册");
        }
        for (CominfoEntity ad : t) {
            cominformation.add(cominformationDao.findById(ad.getCominfoId()).get());
        }

        CompanyEntity company = companyDao.findById(companyId).get();

        return new CominfoContent(cominformation);
    }




}
