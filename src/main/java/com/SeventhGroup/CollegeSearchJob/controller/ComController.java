package com.SeventhGroup.CollegeSearchJob.controller;


import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.dao.CominformationDao;
import com.SeventhGroup.CollegeSearchJob.service.CominformationService;
import com.SeventhGroup.CollegeSearchJob.service.CompanyService;
import com.SeventhGroup.CollegeSearchJob.service.InformationService;
import com.SeventhGroup.CollegeSearchJob.service.UserService;
import com.SeventhGroup.CollegeSearchJob.service.inner.CominformationBodyContent;
import com.SeventhGroup.CollegeSearchJob.service.inner.InformationBodyContent;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(description = "公司信息接口")
public class ComController {

    @Resource
    CompanyService companyservice;

    @Resource
    CominformationService cominformationService;
    @Resource
    CominformationDao cominformationDao;


    /**
     * body格式
     * <p>
     * {
     * "name": "HelloWorld",
     * "email": "my_email",
     * "information": [
     * {
     * "phone": "phone",
     * "sex": "sex",
     * "school": "school",
     * "professional": "professional",
     * "grade": "grade",
     * "education":"education"
     * }
     * ]
     * }
     **/
    @ApiOperation(value = "修改公司信息")
    @RequestMapping(value = "/cpmpany/cominformation/{companyId}", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> post(@PathVariable(value = "companyId") String companyId,
                                    @RequestBody String rawBody) {


        CominformationBodyContent content =
                new Gson().fromJson(rawBody, CominformationBodyContent.class);

        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);
        try {
            cominformationService.postInformation(companyId, content.getCominformation());
            map.put("mag", "success");
        } catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }
        return map;

    }

    @ApiOperation(value = "查看公司信息")
    @RequestMapping(value = "/company/findcominformation/{companyId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> post(@PathVariable(value = "companyId") String companyId) {

        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);

        try {
            map.put("data", cominformationService.fromEntityListGetPicofcomList(cominformationDao.findByCompanyId(companyId)));
        } catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }

        return map;

    }

    @ApiOperation(value = "获取所有公司信息")
    @RequestMapping(value = "/company/findAllcominformation", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findallcom() {

        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);

        try {
            map.put("data", cominformationService.fromEntityListGetPicofcomList(cominformationDao.findAll()));
        } catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }

        return map;

    }

}
