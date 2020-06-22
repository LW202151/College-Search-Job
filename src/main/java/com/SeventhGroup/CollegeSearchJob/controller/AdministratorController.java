package com.SeventhGroup.CollegeSearchJob.controller;


import com.SeventhGroup.CollegeSearchJob.Execptions.GoodNotFoundException;
import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.service.AdministratorService;
import com.SeventhGroup.CollegeSearchJob.service.SeeApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(description = "管理员接口")
public class AdministratorController {
@Resource
    AdministratorService administratorService;
@Resource
    SeeApplicationService seeApplicationService;


    @ApiOperation(value = "管理员注册")
    @ResponseBody
    @RequestMapping(value = "/Administrator/register/{email}/{name}/{password}", method = RequestMethod.GET)

    public Map<String, Object> register(@PathVariable(value = "email") String email,
                                        @PathVariable(value = "name") String name,
                                        @PathVariable(value = "password") String password){


        Map<String, Object> map = new HashMap<>();

        try {
            String userId =  administratorService.register(email,name,password);

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
    @ApiOperation(value = "管理员登录")
    @ResponseBody
    @RequestMapping(value ="administrator/login/{email}/{password}",method = RequestMethod.GET)
    public Map<String, Object> login(@PathVariable(value="email") String email,
                                     @PathVariable(value="password") String password){

        Map<String, Object> map = new HashMap<>();

        String userId =  administratorService.login(email,password);
        setMapFromUserId(map, userId);
        map.put("msg", "登录成功");
        map.put("user_id", userId);
        return map;
    }
    @ApiOperation(value = "修改密码")
    @ResponseBody
    @RequestMapping(value ="administrator/changePassword/{Administrator}/{email}/{password}",method = RequestMethod.GET)
    public Map<String, Object> changePassword(@PathVariable(value="Administrator") String Administrator,
                                              @PathVariable(value="email") String email,
                                              @PathVariable(value="password") String password) {

        Map<String, Object> map = new HashMap<>();

        administratorService.changePassword(Administrator, email, password);
        map.put("msg", "success");
        return map;
    }
    /**
     * 删除非法的招聘
     */
    @ApiOperation(value = "删除不合法的招聘")
    @ResponseBody
    @RequestMapping(value = "/delete/application/{applicationId}", method = RequestMethod.GET)
    public Map<String, Object> deleteapp(@PathVariable(value = "applicationId") String applicationId) {

        Map<String, Object> map = new HashMap<>();

        // deal
        //ArrayList<String> res = (ArrayList<String>) body.get("data");


        try {
            seeApplicationService.underapplication(applicationId);
            map.put("code", 0);
            map.put("msg", "删除成功");
        }
        catch (GoodNotFoundException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }

        return map;


    }


    /**
     * 删除非法的用户
     */
    @ApiOperation(value = "删除不合法的用户")
    @ResponseBody
    @RequestMapping(value = "/delete/user/{userId}", method = RequestMethod.GET)
    public Map<String, Object> deleteuser(@PathVariable(value = "userId") String userId) {

        Map<String, Object> map = new HashMap<>();

        // deal
        //ArrayList<String> res = (ArrayList<String>) body.get("data");


        try {
            seeApplicationService.underuser(userId);
            map.put("code", 0);
            map.put("msg", "删除成功");
        }
        catch (GoodNotFoundException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }

        return map;


    }

    /**
     * 删除非法的公司
     */
    @ApiOperation(value = "删除不合法的公司")
    @ResponseBody
    @RequestMapping(value = "/delete/company/{companyId}", method = RequestMethod.GET)
    public Map<String, Object> deletecompany(@PathVariable(value = "companyId") String companyId) {

        Map<String, Object> map = new HashMap<>();

        // deal
        //ArrayList<String> res = (ArrayList<String>) body.get("data");


        try {
           // seeApplicationService.getremoveApp(companyId);
            seeApplicationService.undercompany(companyId);
            map.put("code", 0);
            map.put("msg", "删除成功");
        }
        catch (GoodNotFoundException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }

        return map;


    }



}
