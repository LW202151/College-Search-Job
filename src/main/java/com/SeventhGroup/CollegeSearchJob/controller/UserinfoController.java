package com.SeventhGroup.CollegeSearchJob.controller;


import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.dao.InformationDao;
import com.SeventhGroup.CollegeSearchJob.service.InformationService;
import com.SeventhGroup.CollegeSearchJob.service.UserService;
import com.SeventhGroup.CollegeSearchJob.service.inner.InformationBodyContent;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(description = "学生信息接口")
public class UserinfoController {
  @Resource
  UserService userservice;
  @Resource
  InformationService informationService;
  @Resource
    InformationDao informationDao;


/**
 *
 * body格式
 *
 * {
 *     "name": "HelloWorld",
 *     "email": "my_email",
 *     "information": [
 *          {
 *              "phone": "phone",
 *              "sex": "sex",
 *              "school": "school",
 *              "professional": "professional",
 *              "grade": "grade",
 *              "education":"education"
 *          }
 *     ]
 * }
 *
 *
**/
@ApiOperation(value = "修改个人信息")
@RequestMapping(value = "/information/{userId}", method = RequestMethod.POST)
@ResponseBody
public Map<String, Object> post(@PathVariable(value = "userId") String userId,
                                @RequestBody String rawBody){


    InformationBodyContent content =
            new Gson().fromJson(rawBody, InformationBodyContent.class);

    Map<String, Object> map = new HashMap<>();

    map.put("code", 0);
    //map.put("mag", "success");
    try {
        informationService.postInformation(userId, content.getInformation());
        map.put("mag", "success");
    }
    catch (SecondRuntimeException e) {
        map.put("code", 1);
        map.put("msg", e.getMessage());
    }
    return map;





}

    @ApiOperation(value = "查看个人信息")
    @RequestMapping(value = "/findinformation/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> post(@PathVariable(value = "userId") String userId){

        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);

        try {
            map.put("data", informationService.fromEntityListGetPicUserList(informationDao.findByUserId(userId)));
        }
        catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }

        return map;

    }

    @ApiOperation(value = "查看所有个人信息")
    @RequestMapping(value = "/findAll/user/information", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findalluser(){

        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);

        try {
            map.put("data", informationService.fromEntityListGetPicUserList(informationDao.findAll()));
        }
        catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }

        return map;

    }


 }








