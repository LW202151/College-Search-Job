package com.SeventhGroup.CollegeSearchJob.controller;


import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.service.CompanyService;
import com.SeventhGroup.CollegeSearchJob.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(description = "公司登录/注册接口")
public class CompanyController {

    @Resource
    private CompanyService companyService;

    @ApiOperation(value = "公司注册")
    @ResponseBody
    @RequestMapping(value = "/company/register/{companyEmail}/{comName}/{comPassword}", method = RequestMethod.GET)

    public Map<String, Object> register(@PathVariable(value = "companyEmail") String companyEmail,
                                        @PathVariable(value = "comName") String comName,
                                        @PathVariable(value = "comPassword") String comPassword){


        Map<String, Object> map = new HashMap<>();

        try {
            String userId =  companyService.register(companyEmail,comName,comPassword);

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
    @ApiOperation(value = "公司登录")
    @ResponseBody
    @RequestMapping(value ="company/login/{companyEmail}/{comPassword}",method = RequestMethod.GET)
    public Map<String, Object> login(@PathVariable(value="companyEmail") String companyEmail,
                                     @PathVariable(value="comPassword") String comPassword) {

        Map<String, Object> map = new HashMap<>();

        String userId = companyService.login(companyEmail, comPassword);
        setMapFromUserId(map, userId);
        map.put("msg", "登录成功");
        map.put("user_id", userId);
        return map;
    }
        @ApiOperation(value = "修改密码")
        @ResponseBody
        @RequestMapping(value ="company/changePassword/{companyId}/{companyEmail}/{code}/{comPassword}",method = RequestMethod.GET)
        public Map<String, Object> changePassword(@PathVariable(value="companyId") String companyId,
                @PathVariable(value="companyEmail") String companyEmail,
                @PathVariable(value="comPassword") String comPassword,
                                                  @PathVariable(value = "code") String code) {

            Map<String, Object> map = new HashMap<>();

            companyService.changePassword(companyId, companyEmail,code , comPassword);
            map.put("msg", "success");
            return map;
        }
    }







