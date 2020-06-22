package com.SeventhGroup.CollegeSearchJob.controller;


import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.service.EmailService;
import com.SeventhGroup.CollegeSearchJob.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(description = "学生登录/注册接口")
public class UserController {
    @Resource
    private  UserService userService;
    @Resource
    EmailService emailService;

/*
    @ApiOperation(value = "获取验证码")
    @ResponseBody
    @RequestMapping(value = "/user/register/{email}", method = RequestMethod.GET)

    public Map<String, Object> register(@PathVariable(value = "email") String email) throws MessagingException {


        Map<String, Object> map = new HashMap<>();
        emailService.sendEmailByInput(email);

        try {
           // String userId =  userService.register(email,name,password);

            //setMapFromUserId(map, userId);
            map.put("msg", "验证码已发送");
            //map.put("user_id", userId);
            //map.setMapFromUserId();

        } catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }

        return map;
    }


*/



    @ApiOperation(value = "学生注册")
    @ResponseBody
    @RequestMapping(value = "/user/register/{email}/{name}/{password}", method = RequestMethod.GET)

    public Map<String, Object> register(@PathVariable(value = "email") String email,
                                        @PathVariable(value = "name") String name,
                                        @PathVariable(value = "password") String password) throws MessagingException {


        Map<String, Object> map = new HashMap<>();
       //emailService.sendEmailByInput(email);
        
            try {
                String userId =  userService.register(email,name,password);

                setMapFromUserId(map, userId);
                map.put("msg", "注册成功");
                map.put("user_id", userId);
                //map.setMapFromUserId();

            } catch (SecondRuntimeException e) {
                map.put("code", 1);
                map.put("msg", e.getMessage());
            }

            return map;
        }

    private void setMapFromUserId(Map<String, Object> map, String userId) {
    }
    @ApiOperation(value = "学生登录")
    @ResponseBody
    @RequestMapping(value ="user/login/{email}/{password}",method = RequestMethod.GET)
    public Map<String, Object> login(@PathVariable(value="email") String email,
                                     @PathVariable(value="password") String password){

        Map<String, Object> map = new HashMap<>();

             String userId =  userService.login(email,password);
             setMapFromUserId(map, userId);
             map.put("msg", "登录成功");
             map.put("user_id", userId);
             return map;
    }
    @ApiOperation(value = "修改密码")
    @ResponseBody
    @RequestMapping(value ="user/changePassword/{userId}/{email}/{code}/{password}",method = RequestMethod.GET)
    public Map<String, Object> changePassword(@PathVariable(value="userId") String userId,
                                     @PathVariable(value="email") String email,
                                              @PathVariable(value="password") String password,
                                              @PathVariable(value = "code") String code) {

        Map<String, Object> map = new HashMap<>();

            userService.changePassword(userId, email, code ,password);
            map.put("msg", "success");
            return map;
    }
}








