package com.SeventhGroup.CollegeSearchJob.controller;

import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.service.PicOfcomService;
import com.SeventhGroup.CollegeSearchJob.service.PicUserService;
import com.SeventhGroup.CollegeSearchJob.service.PicofadministratorService;
import com.SeventhGroup.CollegeSearchJob.service.PicofappService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(description="图片接口")
public class PicUserController {
   @Resource
    PicUserService picUserService;
   @Resource
    PicOfcomService picOfcomService;
   @Resource
    PicofappService picofappService;
   @Resource
    PicofadministratorService picofadministratorService;

    @ApiOperation(value="学生上传图片")
    @ResponseBody
    @RequestMapping(value = "/user/picture/{userId}",method = RequestMethod.POST)
    public Map<String, Object> upload(@PathVariable(value = "userId") String userId,
                                      @RequestParam("file") MultipartFile file){
        Map<String, Object> map = new HashMap<>();

        try {
            picUserService.upload(userId, file.getInputStream(), file.getOriginalFilename());
            map.put("code", 0);
            map.put("msg", "success");
            map.put("url",picUserService.fromUserIdGetUrl(userId));

        } catch (IOException e) {
            map.put("code", 2);
            map.put("msg", e.getMessage());
        } catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }

        return map;
    }

    @ApiOperation(value="公司上传图片")
    @ResponseBody
    @RequestMapping(value = "/companypicture/{companyId}",method = RequestMethod.POST)
    public Map<String, Object> Comupload(@PathVariable(value = "companyId") String companyId,
                                      @RequestParam("file") MultipartFile file){
        Map<String, Object> map = new HashMap<>();

        try {
            picOfcomService.upload(companyId, file.getInputStream(), file.getOriginalFilename());
            map.put("code", 0);
            map.put("msg", "success");
            map.put("url",picOfcomService.fromUserIdGetUrl(companyId));

        } catch (IOException e) {
            map.put("code", 2);
            map.put("msg", e.getMessage());
        } catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }

        return map;
    }
    @ApiOperation(value="招聘上传图片")
    @ResponseBody
    @RequestMapping(value = "/Apppicture/{applicationId}",method = RequestMethod.POST)
    public Map<String, Object> Appupload(@PathVariable(value = "applicationId") String applicationId,
                                         @RequestParam("file") MultipartFile file){
        Map<String, Object> map = new HashMap<>();

        try {
            picofappService.upload(applicationId, file.getInputStream(), file.getOriginalFilename());
            map.put("code", 0);
            map.put("msg", "success");
            map.put("url",picofappService.fromUserIdGetUrl(applicationId));

        } catch (IOException e) {
            map.put("code", 2);
            map.put("msg", e.getMessage());
        } catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }

        return map;
    }
    @ApiOperation(value="管理员上传图片")
    @ResponseBody
    @RequestMapping(value = "/administratorPicture/{administratorId}",method = RequestMethod.POST)
    public Map<String, Object> adupload(@PathVariable(value = "administratorId") String administratorId,
                                         @RequestParam("file") MultipartFile file){
        Map<String, Object> map = new HashMap<>();

        try {
            picofadministratorService.upload(administratorId, file.getInputStream(), file.getOriginalFilename());
            map.put("code", 0);
            map.put("msg", "success");
         map.put("url",picofadministratorService. fromUserIdGetUrl(administratorId ));

        } catch (IOException e) {
            map.put("code", 2);
            map.put("msg", e.getMessage());
        } catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }

        return map;
    }
}
