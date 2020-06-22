package com.SeventhGroup.CollegeSearchJob.controller;


import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.service.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(description = "验证码")
public class CodeController {

   @Resource
    EmailService emailService;

    @ApiOperation(value = "获取验证码")
    @ResponseBody
    @RequestMapping(value = "/gain/code/{email}", method = RequestMethod.GET)

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




}
