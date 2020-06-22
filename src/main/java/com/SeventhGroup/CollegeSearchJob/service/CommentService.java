package com.SeventhGroup.CollegeSearchJob.service;


import com.SeventhGroup.CollegeSearchJob.Execptions.SecondRuntimeException;
import com.SeventhGroup.CollegeSearchJob.dao.AppOfcomDao;
import com.SeventhGroup.CollegeSearchJob.dao.CommentDao;
import com.SeventhGroup.CollegeSearchJob.dao.SearchDao;
import com.SeventhGroup.CollegeSearchJob.dao.UserDao;
import com.SeventhGroup.CollegeSearchJob.entity.AppOfcomEntity;
import com.SeventhGroup.CollegeSearchJob.entity.CommentsEntity;
import com.SeventhGroup.CollegeSearchJob.util.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommentService {
    @Resource
    SearchDao searchDao;
    @Resource
    UserDao userDao;
    @Resource
    UserService userService;
    @Resource
    CommentDao commentDao;
    @Resource
    AppOfcomDao appOfcomDao;

    public boolean checkGoodExist(String applicationId) {
        return searchDao.findByApplicationId(applicationId).size() != 0;
    }

    public String comments(String userId, String companyId, String applicationId, String content) throws SecondRuntimeException {
        List<AppOfcomEntity> check = appOfcomDao.findByCompanyIdAndApplicationId(companyId,applicationId);
        if (!userService.checkUserIdExist(userId)) {
            throw new SecondRuntimeException("用户id不存在，无法发布评论，请注册");
        }
        if (check.size()==0) {
            throw new SecondRuntimeException("招聘未存在，无法发布评论");
        }

        String commentId = Util.getUniqueId();

        commentDao.save(new CommentsEntity(commentId,userId, companyId, applicationId, content, Util.getNowTime()));
        //appOfcomDao.save(new AppOfcomEntity(applicationId, companyId));
        return commentId;
    }

    public List<CommentsEntity> findAllByDate(String userId) {
        List<CommentsEntity> entity = commentDao.findByUserId(userId);

        entity.sort((o1, o2) -> Util.compareDateFromString(o1.getCommenttime(), o2.getCommenttime()));

        return entity;
    }

    public String findAllUserId(String userId) throws SecondRuntimeException {
        List<CommentsEntity> checkUserId = commentDao.findByUserId(userId);
        if (checkUserId.size() == 0) {
            throw new SecondRuntimeException("用户未发布评论或用户未注册");
        }
        return checkUserId.get(0).getUserId();
    }

    public String findAllapplication(String applicationId) throws SecondRuntimeException {
        List<CommentsEntity> checkapplication= commentDao.findByApplicationId(applicationId);
        if (checkapplication.size() == 0) {
            throw new SecondRuntimeException("招聘未发布，无法查看评论");
        }
        return checkapplication.get(0).getApplicationId();
    }
    public List<CommentsEntity> findAllDate(String applicationId) {
        List<CommentsEntity> entity = commentDao.findByApplicationId(applicationId);

        entity.sort((o1, o2) -> Util.compareDateFromString(o1.getCommenttime(), o2.getCommenttime()));

        return entity;
    }
    @Transactional
    public void under(String commentId) throws SecondRuntimeException {


        List<CommentsEntity> temp = commentDao.findByCommentId(commentId);

        if (temp.size() == 0) {
            throw new SecondRuntimeException("评论不存在,无法进行删除");
        }

        commentDao.deleteByCommentId(commentId);
        //appOfcomDao.deleteByApplicationId(applicationId);

    }
}
