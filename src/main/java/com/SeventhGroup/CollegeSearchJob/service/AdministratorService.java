package com.SeventhGroup.CollegeSearchJob.service;

import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.dao.AdministratorDao;
import com.SeventhGroup.CollegeSearchJob.entity.AdministratorEntity;
import com.SeventhGroup.CollegeSearchJob.entity.User;
import com.SeventhGroup.CollegeSearchJob.util.Util;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdministratorService {
@Resource
    AdministratorDao administratorDao;

    public  boolean checkUserIdExist(String administratorId) {
        return administratorDao.findById(administratorId).isPresent();
    }
    public String register (String email,String name,String password) throws SecondRuntimeException {
        String adminiStratorId = Util.getUniqueId();

        List<AdministratorEntity> checkEmail = administratorDao.findByEmail(email);
        List<AdministratorEntity> checkName = administratorDao.findByName(name);
        List<AdministratorEntity> checkPassword = administratorDao.findByPassword(password);

        // List<User> checkEmail = userdao.findByEmail(email);
        if (checkEmail.size() > 0 && checkEmail.size()==1) {
            throw new SecondRuntimeException("管理员只有一个");
        }
        if (checkName.size() > 0) {
            throw new SecondRuntimeException("该名称已被使用");
        }
        if (checkPassword.size() > 0) {
            throw new SecondRuntimeException("该密码已经被使用过,请重新输入");
        }
        administratorDao.save(new AdministratorEntity(adminiStratorId, email, name, password));

        return adminiStratorId;
    }

    public String login(String email,String password){
        List<AdministratorEntity> checkEmail = administratorDao.findByEmail(email);
        List<AdministratorEntity> checkPassword = administratorDao.findByPassword(password);
        List<AdministratorEntity> check = administratorDao.findByEmailAndPassword(email,password);

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
    public String changePassword(String adminiStratorId, String email,String password){
/*
      修改密码
       */
        List<AdministratorEntity> checkEmail = administratorDao.findByEmail(email);
        if (checkEmail.size()==0) {
            throw  new SecondRuntimeException("该用户不存在，无法修改密码");
        }
        AdministratorEntity userop =administratorDao.findById(adminiStratorId).get();
        userop.setPassword(password);
        administratorDao.save(userop);
        return password;

    }

    }
