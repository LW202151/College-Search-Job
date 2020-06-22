package com.SeventhGroup.CollegeSearchJob.controller;


import com.SeventhGroup.CollegeSearchJob.Execptions.GoodNotFoundException;
import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.dao.AppOfcomDao;
import com.SeventhGroup.CollegeSearchJob.dao.SearchDao;
import com.SeventhGroup.CollegeSearchJob.entity.ApplicationEntity;
import com.SeventhGroup.CollegeSearchJob.service.SeeApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(description="招聘接口")
public class SearchController {

    @Resource
    SeeApplicationService seeApplicationService;
    @Resource
    SearchDao searchDao;
    @Resource
    AppOfcomDao appOfcomDao;


    /***
     * 发布应聘
     * @param comName
     * @param companydesc
     * @param position
     * @param positiondesc
     * @param requirement
     * @param num
     * @param money
     * @param address
     */
    @ApiOperation(value = "发布招聘")
    @ResponseBody
    @RequestMapping(value = "/company/application/{comName}/{companydesc}/{position}/{positiondesc}/{requirement}/{num}/{money}/{address}/{tag}/{companyId}",
            method = RequestMethod.GET)
    public Map<String, Object> postGood(@PathVariable(value = "comName") String comName,
                                        @PathVariable(value = "companydesc") String companydesc,
                                        @PathVariable(value = "position") String position,
                                        @PathVariable(value = "positiondesc") String positiondesc,
                                        @PathVariable(value = "requirement") String requirement,
                                        @PathVariable(value = "num") Integer num,
                                        @PathVariable(value = "money") Float money,
                                        @PathVariable(value = "address") String address,
                                        @PathVariable(value = "tag") String tag,
                                        @PathVariable(value = "companyId") String companyId) {

        Map<String, Object> map = new HashMap<>();


        try {
            map.put("code", 0);
          map.put("applicationId", seeApplicationService.postGood(comName, companydesc, position, positiondesc, requirement, num, money, address, tag,companyId));
        } catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }
        return map;

    }

    /***
     * 根据公司名查找招聘
     */

    @ApiOperation(value = "公司名(comName)查找招聘")
    @ResponseBody
    @RequestMapping(value = "/findAll/comName/{comName}", method = RequestMethod.GET)
    public Map<String, Object> findAllName(@PathVariable(value = "comName") String comName) {

        Map<String, Object> map = new HashMap<>();

        seeApplicationService.findByName(comName);
        map.put("code", 0);
//seeApplicationService.fromEntityListGetPicappList(searchDao.findByComName(comName));
//        }
        map.put("data", seeApplicationService.fromEntityListGetPicappList(searchDao.findByComName(comName)));

        return map;
    }




/*
    //模糊查询
    @ApiOperation(value = "公司名(comName)查找招聘")
    @ResponseBody
    @RequestMapping(value="dim")
    public String dim(Model model, HttpServletRequest request) {
        String name=request.getParameter("name");		//获取html页面搜索框的值
        List<ApplicationEntity> unit=seeApplicationService.findByName(name);	//在数据库中进行查询
        model.addAttribute("unit", unit);	//模板映射
        return "page/demo/dim";
    }


*/




    /***
     * 根据position查找招聘
     */

    @ApiOperation(value = "职位(position)查找招聘")
    @ResponseBody
    @RequestMapping(value = "/findAll/position/{position}", method = RequestMethod.GET)
    public Map<String, Object> findAllPosition(@PathVariable(value = "position") String position) {

        Map<String, Object> map = new HashMap<>();

        seeApplicationService.findAllPosition(position);
        map.put("code", 0);

        map.put("data", seeApplicationService.fromEntityListGetPicappList(searchDao.findByPosition(position)));

        return map;
    }
    /***
     * 根据tag查找招聘
     */
    @ApiOperation(value = "查找相关类型(tag)的招聘")
    @ResponseBody
    @RequestMapping(value = "/findAll/tag/{tag}", method = RequestMethod.GET)
    public Map<String, Object> findAllTag(@PathVariable(value = "tag") String tag) {

        Map<String, Object> map = new HashMap<>();

        seeApplicationService.findAllTag(tag);
        map.put("code", 0);

        map.put("data", seeApplicationService.fromEntityListGetPicappList(searchDao.findByTag(tag)));

        return map;
    }
    /**
     * 查看所有的招聘（时间排序）
     */

    @ApiOperation(value = "查看所有公司发布的招聘（时间排序）")
    @ResponseBody
    @RequestMapping(value = "/findAll/sort", method = RequestMethod.GET)
    public Map<String, Object> findAllsort() {

        Map<String, Object> map = new HashMap<>();

        //seeApplicationService.findAllApplicationId(applicationId);
        map.put("code", 0);

        map.put("data", seeApplicationService.fromEntityListGetPicappList(seeApplicationService.findAllByDate()));

        return map;

    }

    /**
     * 查看公司已发布的招聘（时间排序）
     */

    @ApiOperation(value = "查看公司已发布的招聘（时间排序）")
    @ResponseBody
    @RequestMapping(value = "/findAll/appOfcom/sort/{companyId}", method = RequestMethod.GET)
    public Map<String, Object> findAppOfsort(@PathVariable(value = "companyId") String companyId) {

        Map<String, Object> map = new HashMap<>();
        //seeApplicationService.findAllApplicationId(applicationId);
        map.put("code", 0);

        map.put("data", seeApplicationService.fromEntityListGetPicappList(seeApplicationService.getComApp(companyId)));

        return map;

    }



    /**
     * 删除已发布的招聘
     */
    @ApiOperation(value = "删除已发布的招聘")
    @ResponseBody
    @RequestMapping(value = "/delete/{applicationId}", method = RequestMethod.GET)
    public Map<String, Object> delete(@PathVariable(value = "applicationId") String applicationId) {

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
    /***
     * 查看招聘详情
     */
    @ApiOperation(value = "查看招聘详情")
    @ResponseBody
    @RequestMapping(value = "/informatio/application/{applicationId}", method = RequestMethod.GET)
    public Map<String, Object> findapplication(@PathVariable(value = "applicationId") String applicationId) {

        Map<String, Object> map = new HashMap<>();

        //seeApplicationService.findAllApplicationId(applicationId);
        seeApplicationService.findAllApplicationId(applicationId);
        map.put("code", 0);

        map.put("data", searchDao.findByApplicationId(applicationId));

        return map;

    }

    /***
     * 获取公司id
     */
    @ApiOperation(value = "获取公司id")
    @ResponseBody
    @RequestMapping(value = "find/companyId/{applicationId}", method = RequestMethod.GET)
    public Map<String, Object> findcompanyId(@PathVariable(value = "applicationId") String applicationId) {

        Map<String, Object> map = new HashMap<>();

        //seeApplicationService.findAllApplicationId(applicationId);
       seeApplicationService.findcomanyid(applicationId);
        map.put("code", 0);

        map.put("data", appOfcomDao.findByApplicationId(applicationId));

        return map;

    }







/*
    @ApiOperation(value = "查看本公司发布的招聘（时间排序）")
    @ResponseBody
    @RequestMapping(value = "/findAll/sort", method = RequestMethod.GET)
    public Map<String, Object> findAllsort() {

        Map<String, Object> map = new HashMap<>();

        //seeApplicationService.findAllApplicationId(applicationId);
        map.put("code", 0);

        map.put("data", seeApplicationService.fromEntityListGetPicappList(seeApplicationService.findAllByDate()));

        return map;

    }
    */


}