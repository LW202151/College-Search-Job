package com.SeventhGroup.CollegeSearchJob.service;


import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.dao.*;
import com.SeventhGroup.CollegeSearchJob.entity.*;
import com.SeventhGroup.CollegeSearchJob.service.inner.UserinfoContent;
import com.SeventhGroup.CollegeSearchJob.util.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
@Resource
UserDao userdao;
@Resource
UserinfoDao userinfodao;
@Resource
InformationDao informationDao;
@Resource
    CompanyDao companyDao;
@Resource
    UserOfemailDao userOfemailDao;
@Resource
CheckcodeDao checkcodeDao;


public  boolean checkUserIdExist(String userId) {
        return userdao.findById(userId).isPresent();
    }
public String register (String email,String name,String password) throws SecondRuntimeException {
    String userId = Util.getUniqueId();

    List<User> checkEmail = userdao.findByEmail(email);
    List<User> checkName = userdao.findByName(name);
    List<User> checkPassword = userdao.findByPassword(password);
    List<CheckcodeEntity> checkcode = checkcodeDao.findByCode(name);

   // List<User> checkEmail = userdao.findByEmail(email);
    if (checkEmail.size() > 0 ) {
        throw  new SecondRuntimeException("该用户已注册");
    }
    if (checkName.size() > 0 ) {
        throw  new SecondRuntimeException("该验证码已被使用过");
    }
    if (checkcode.size() ==0 ) {
        throw  new SecondRuntimeException("验证码错误");
    }
        if (checkPassword.size() > 0) {
        throw  new SecondRuntimeException("该密码已经被使用过,请重新输入");
    }
        userdao.save(new User(userId, email, name,password));
        userOfemailDao.save(new UserOfemailEntity(userId , email));
        return userId;

}

    public String emailget(String userId){
    List<UserOfemailEntity> temp = userOfemailDao.findByUserId(userId);
    return  temp.get(0).getEmail();

    }


   public String login(String email,String password){
       List<User> checkEmail = userdao.findByEmail(email);
       List<User> checkPassword = userdao.findByPassword(password);
       List<User> check = userdao.findByEmailAndPassword(email,password);

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
public String changePassword(String userId, String email,String code,String password){
/*
      覆盖个人信息
       */
    List<User> checkEmail = userdao.findByEmail(email);
    List<User> checkName = userdao.findByName(code);

    List<CheckcodeEntity> checkcodeUserpassword = checkcodeDao.findByCode(code);

    if (checkEmail.size()==0) {
        throw  new SecondRuntimeException("该用户不存在，无法修改密码");
    }
    if (checkName.size() > 0) {
        throw  new SecondRuntimeException("验证码已被使用过");
    }
    if (checkcodeUserpassword.size()==0) {
        throw  new SecondRuntimeException("验证码错误");
    }
    User userop =userdao.findById(userId).get();
    userop.setPassword(password);
    userdao.save(userop);
    return password;


}

    /**
     * 获取个人信息
     * @param userId userId
     * @return InfoContent
     *
     */
    public UserinfoContent getInfo(String userId) throws SecondRuntimeException{
        List<informationEntity> information = new ArrayList<>();
        List<UserinfoEntity> t = userinfodao.findByuserId(userId);

        if (!this.checkUserIdExist(userId)) {
            throw new SecondRuntimeException("用户id不存在，无法查看个人信息，请注册");
        }
        for (UserinfoEntity ad : t) {
            information.add(informationDao.findById(ad.getInfoId()).get());
        }

        User user = userdao.findById(userId).get();

        return new UserinfoContent(information);
    }


}
