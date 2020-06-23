package com.SeventhGroup.CollegeSearchJob.controller;


import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.service.CominformationService;
import com.SeventhGroup.CollegeSearchJob.service.HistoryService;
import com.SeventhGroup.CollegeSearchJob.service.InformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(description = "推荐接口")

public class HistoryController {
    @Resource
    CominformationService cominformationService;
    @Resource
    HistoryService recommendService;
    @Resource
    InformationService informationService;

    @ApiOperation(value = "推荐公司")
    @RequestMapping(value = "/recom/recomComp/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> recomComp(@PathVariable(value = "userId") String userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        try {
            map.put("data", cominformationService.fromEntityListGetPicofcomList(recommendService.findChainForStu(userId, "S2C")));
        } catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }
        return map;
    }

    @ApiOperation(value = "记录点击历史")
    @RequestMapping(value = "/recom/writehis/{userId}/{comId}/{type}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> writeHis(@PathVariable(value = "userId") String userId,

                                        @PathVariable(value = "comId") String comId,
                                        @PathVariable(value = "type") String type)
    {
        recommendService.insertHistory(userId, comId, type);

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("status", "ok");
        return map;
    }

    @ApiOperation(value = "推荐学生")
    @RequestMapping(value = "/recom/recomStu/{comId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> recomStu(@PathVariable(value = "comId") String comId) {
        Map<String, Object> map = new HashMap<>();
        System.out.println("get");
        map.put("code", 0);
        try {
            map.put("data", informationService.fromEntityListGetPicUserList(recommendService.findChainForCom(comId, "C2S")));
        } catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }
        return map;
    }}
