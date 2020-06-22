package com.SeventhGroup.CollegeSearchJob.controller;


import com.SeventhGroup.CollegeSearchJob.Execptions.GoodNotFoundException;
import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(description = "评论接口")
public class CommentsController {
@Resource
    CommentService commentService;

    @ApiOperation(value = "发布评论")
    @ResponseBody
    @RequestMapping(value = "/comment/{userId}/{companyId}/{applicationId}/{content}",
            method = RequestMethod.GET)
    public Map<String, Object> comment(@PathVariable(value = "userId") String userId,
                                        @PathVariable(value = "companyId") String companyId,
                                        @PathVariable(value = "applicationId") String applicationId,
                                        @PathVariable(value = "content") String content) {

        Map<String, Object> map = new HashMap<>();


        try {
            map.put("code", 0);
            map.put("commentId", commentService.comments(userId,companyId,applicationId, content));
        } catch (SecondRuntimeException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }
        return map;

    }

    /***
     * 用户查找已发布的评论
     */
    @ApiOperation(value = "用户查找已发布的评论")
    @ResponseBody
    @RequestMapping(value = "/user/findcomment/{userId}", method = RequestMethod.GET)
    public Map<String, Object> findAlluser(@PathVariable(value = "userId") String userId) {

        Map<String, Object> map = new HashMap<>();

        commentService.findAllUserId(userId);
        map.put("code", 0);

        map.put("data", commentService.findAllByDate(userId));

        return map;
    }
    /***
     * 查找关于招聘的评论
     */
    @ApiOperation(value = "查找关于招聘的评论")
    @ResponseBody
    @RequestMapping(value = "/appilication/findcomment/{applicationId}", method = RequestMethod.GET)
    public Map<String, Object> findAllappication(@PathVariable(value = "applicationId") String applicationId) {

        Map<String, Object> map = new HashMap<>();

        commentService.findAllapplication(applicationId);
        map.put("code", 0);

        map.put("data", commentService.findAllDate(applicationId));

        return map;
    }
    /**
     * 删除已发布的评论
     */
    @ApiOperation(value = "删除评论")
    @ResponseBody
    @RequestMapping(value = "/deleteComment/{commentId}", method = RequestMethod.GET)
    public Map<String, Object> deleteComment(@PathVariable(value = "commentId") String commentId) {

        Map<String, Object> map = new HashMap<>();

        // deal
        //ArrayList<String> res = (ArrayList<String>) body.get("data");


        try {
            commentService.under(commentId);
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
