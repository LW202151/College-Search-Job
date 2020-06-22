package com.SeventhGroup.CollegeSearchJob.controller;

import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.dao.AlreadyAccessOfcomDao;
import com.SeventhGroup.CollegeSearchJob.dao.AlreadyAccessOfuserDao;
import com.SeventhGroup.CollegeSearchJob.dao.ResumeOfthreeDao;
import com.SeventhGroup.CollegeSearchJob.dao.UserAccessyesDao;
import com.SeventhGroup.CollegeSearchJob.entity.ComAlrealdyAccessEntity;
import com.SeventhGroup.CollegeSearchJob.service.ResumeService;
import com.SeventhGroup.CollegeSearchJob.service.ResumeyesService;
import com.SeventhGroup.CollegeSearchJob.service.SendresumeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@RestController
@Api(description = "审核接口")
public class AccessController {

    @Resource
    SendresumeService sendresumeService;
    @Resource
    AlreadyAccessOfcomDao alreadyAccessOfcomDao;
    @Resource
    AlreadyAccessOfuserDao alreadyAccessOfuserDao;
    @Resource
    ResumeOfthreeDao resumeOfthreeDao;
    @Resource
    UserAccessyesDao userAccessyesDao;

    /**
     * 公司审核简历
     * @param companyId
     * @param resumeId
     * @return
     */
    @ApiOperation(value = "公司审核简历")
    @RequestMapping(value = "/company/resumeAcees/{companyId}/{applicationId}/{resumeId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> buy(@PathVariable(value = "companyId") String companyId,
                                   @PathVariable(value = "applicationId") String applicationId,
                                   @PathVariable(value = "resumeId") String resumeId) {

        Map<String, Object> map = new HashMap<>();
        try {
        sendresumeService.buy(companyId, applicationId,resumeId);
        map.put("code", 0);
            map.put("msg","简历正在审核...");
    }
    catch (SecondRuntimeException e) {
        map.put("code", 1);
        map.put("msg", e.getMessage());

    }

    return map;

}

    @ApiOperation(value = "公司发布简历审核结果")
    @RequestMapping(value = "/company/resumeYes/{companyId}/{resumeId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> UserAccessYes(@PathVariable(value = "companyId") String companyId,
                                   @PathVariable(value = "resumeId") String resumeId) {

        Map<String, Object> map = new HashMap<>();
        try {
            sendresumeService.Yes(companyId, resumeId);
            map.put("code", 0);
            map.put("msg","简历通过审核...");
        }
        catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }

        return map;

    }



    /**
     * 学生审核未通过的简历
     * @param userId
     * @return
     */
    @ApiOperation(value = "学生审核未通过的简历")
@RequestMapping(value = "/userAlreadyAccess/{userId}", method = RequestMethod.GET)
@ResponseBody
public Map<String, Object> getWhatISell(@PathVariable(value = "userId") String userId) {


    Map<String, Object> map = new HashMap<>();

    map.put("code", 0);
//    map.put("data", sendresumeService.fromEntityListGetResumeList(sendresumeService.getUserAlreadyAccess(userId)));
    map.put("data",alreadyAccessOfuserDao.findByUserId((userId)));
    return map;

}

    /**
     * 学生已审核通过的简历
     * @param userId
     * @return
     */
    @ApiOperation(value = "学生审核通过的简历")
    @RequestMapping(value = "/userAlreadyYes/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserYes(@PathVariable(value = "userId") String userId) {


        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);
//    map.put("data", sendresumeService.fromEntityListGetResumeList(sendresumeService.getUserAlreadyAccess(userId)));
        map.put("data",userAccessyesDao.findByUserId((userId)));
        return map;

    }


    @ApiOperation(value = "学生未审核的简历）")
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

    /**
     * 公司获得所有已审核的简历
     * @param companyId
     * @return
     */
    @ApiOperation(value = "公司所有已审核的简历")
    @RequestMapping(value = "/companyAlreadyAccess/{companyId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getWhatIBuy(@PathVariable(value = "companyId") String companyId) {

        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);
        map.put("data",alreadyAccessOfcomDao.findByCompanyId((companyId)));

        return map;

    }

    @ApiOperation(value = "公司所有未审核的简历")
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

    @ApiOperation(value = "招聘未审核的简历")
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

    @ApiOperation(value = "招聘已审核的简历")
    @ResponseBody
    @RequestMapping(value = "/findAll/accessresume/{companyId}/{applicationId}", method = RequestMethod.GET)
    public Map<String, Object> findrByResumeaccess(@PathVariable(value = "companyId") String companyId
            ,@PathVariable(value = "applicationId") String applicationId) {

        Map<String, Object> map = new HashMap<>();

        //seeApplicationService.findAllPosition(position);
        map.put("code", 0);
        try {
            // map.put("data", sendresumeService.fromEntityListGetResumeList(sendresumeService.findBy(companyId,applicationId)));
            map.put("data",alreadyAccessOfcomDao.findByCompanyIdAndApplicationId(companyId,applicationId));

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
        //sendresumeService.findsendresume(resumeId);
        map.put("code", 0);
        map.put("data", sendresumeService.fromEntityGetResumeThreeList(resumeOfthreeDao.findByResumeId(resumeId)));
        return map;
    }




}
