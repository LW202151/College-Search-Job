package com.SeventhGroup.CollegeSearchJob.controller;

import com.SeventhGroup.CollegeSearchJob.Execptions.GoodNotFoundException;
import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.dao.AlreadyAccessOfcomDao;
import com.SeventhGroup.CollegeSearchJob.dao.ResumeDao;
import com.SeventhGroup.CollegeSearchJob.dao.ResumeOfthreeDao;
import com.SeventhGroup.CollegeSearchJob.dao.SendresumeDao;
import com.SeventhGroup.CollegeSearchJob.service.ResumeService;
import com.SeventhGroup.CollegeSearchJob.service.SendresumeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(description = "简历接口")
public class ResumeController {

    @Resource
    ResumeService resumeService;
    @Resource
    ResumeDao resumeDao;
    @Resource
    SendresumeService sendresumeService;
    @Resource
    SendresumeDao sendresumeDao;
    @Resource
    AlreadyAccessOfcomDao alreadyAccessOfcomDao;
    @Resource
    ResumeOfthreeDao resumeOfthreeDao;



    @ApiOperation(value="学生投递简历")
    @ResponseBody
    @RequestMapping(value = "/user/sendresume/{userId}}/{companyId}/{applicationId}",method = RequestMethod.POST)
    public Map<String, Object> sendresume(@PathVariable(value = "userId") String userId,
                                      @PathVariable(value = "companyId") String companyId,
                                      @PathVariable(value = "applicationId") String applicationId,
                                      @RequestParam("file") MultipartFile file){
        Map<String, Object> map = new HashMap<>();

        try {
            //sendresumeService.uploadOne(userId,companyId,applicationId,file.getInputStream(), file.getOriginalFilename());

            sendresumeService.upload(userId,companyId,applicationId,file.getInputStream(), file.getOriginalFilename());
            map.put("code", 0);
            //map.put("data", sendresumeService.fromEntityListGetResumeList(sendresumeDao.findByUserId(userId)));
            map.put("msg", "successs");
            map.put("url",sendresumeService.fromUserIdGetUrl(userId));
            map.put("url(备用）",sendresumeService.fromUserIdGetUrl1(userId));



        } catch (IOException e) {
            map.put("code", 2);
            map.put("msg", e.getMessage());
        } catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }

        return map;
    }
   /*
    @ApiOperation(value = "学生已投递的简历（投递但未审核的简历）")
    @ResponseBody
    @RequestMapping(value = "/findAll/sendresume/{userId}", method = RequestMethod.GET)
    public Map<String, Object> findsendResume(@PathVariable(value = "userId") String userId) {

        Map<String, Object> map = new HashMap<>();

        //seeApplicationService.findAllPosition(position);
        map.put("code", 0);
        try {
            map.put("data", sendresumeService.fromEntityListGetResumeList(sendresumeService.findAllByDate(userId)));
        }
        catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }
        return map;
    }
    @ApiOperation(value = "公司已接收的简历(所有）")
    @ResponseBody
    @RequestMapping(value = "/findAll/receiveresume/{companyId}", method = RequestMethod.GET)
    public Map<String, Object> findreceiveResume(@PathVariable(value = "companyId") String companyId) {

        Map<String, Object> map = new HashMap<>();

        //seeApplicationService.findAllPosition(position);
        map.put("code", 0);
        try {
            map.put("data", sendresumeService.fromEntityListGetResumeList(sendresumeService.findByDate(companyId)));
        }
        catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }
        return map;

    }

    @ApiOperation(value = "相关招聘已接收的简历（当前招聘未审核的简历）")
    @ResponseBody
    @RequestMapping(value = "/findAll/receiveresume/{companyId}/{applicationId}", method = RequestMethod.GET)
    public Map<String, Object> findrByeceiveResume(@PathVariable(value = "companyId") String companyId
                          ,@PathVariable(value = "applicationId") String applicationId) {

        Map<String, Object> map = new HashMap<>();

        //seeApplicationService.findAllPosition(position);
        map.put("code", 0);
        try {
            map.put("data", sendresumeService.fromEntityListGetResumeList(sendresumeService.findBy(companyId,applicationId)));
        }
        catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }
        return map;

    }

    @ApiOperation(value = "相关招聘已审核）")
    @ResponseBody
    @RequestMapping(value = "/findAll/accessresume/{companyId}/{resumeId}", method = RequestMethod.GET)
    public Map<String, Object> findrByResumeaccess(@PathVariable(value = "companyId") String companyId
            ,@PathVariable(value = "resumeId") String resumeId) {

        Map<String, Object> map = new HashMap<>();

        //seeApplicationService.findAllPosition(position);
        map.put("code", 0);
        try {
           // map.put("data", sendresumeService.fromEntityListGetResumeList(sendresumeService.findBy(companyId,applicationId)));
              map.put("data",resumeOfthreeDao.findByCompanyIdAndResumeId(companyId,resumeId));
        }
        catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }
        return map;

    }









    @ApiOperation(value = "查看简历")
    @ResponseBody
    @RequestMapping(value = "/look/sendresume/{resumeId}", method = RequestMethod.GET)
    public Map<String, Object> LooksendResume(@PathVariable(value = "resumeId") String resumeId) {

        Map<String, Object> map = new HashMap<>();

        //seeApplicationService.findAllPosition(position);
        sendresumeService.findsendresume(resumeId);
        map.put("code", 0);
        map.put("data", sendresumeService.fromEntityListGetResumeList(sendresumeDao.findByResumeId(resumeId)));
        return map;
    }

*/


}
