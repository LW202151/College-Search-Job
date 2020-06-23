package com.SeventhGroup.CollegeSearchJob.service;


import com.SeventhGroup.CollegeSearchJob.dao.CheckcodeDao;
import com.SeventhGroup.CollegeSearchJob.entity.CheckcodeEntity;
import com.SeventhGroup.CollegeSearchJob.util.Util;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zjl
 */
@Service
public class EmailService {

    @Resource
    CheckcodeDao checkcodeDao;
    //private Properties props = System.getProperties();

    public void sendEmailByInput(String email) throws MessagingException {
        Properties props = System.getProperties();
        String KEY = "123456"; // KEY为自定义秘钥

        /**测试用的邮箱名*/
        //email = "1563180669@qq.com";
        if (props == null) {
            props = System.getProperties();
        }
        /**使用QQ邮箱的SMTP服务*/
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.qq.com");
        Session session = Session.getInstance(props);
        session.setDebug(true);

        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress("398589287@qq.com"));
        /**生成验证码*/
        String code = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            //每次随机出一个数字（0-9）
            int r = random.nextInt(10);
            //把每次随机出的数字拼在一起
            code = code + r;
        }
        //List<String> iscode = new ArrayList<>();
        // iscode.put("data",code);

        /**设置邮件内容*/
        message.setText("你的验证码为：" + code + "。请注意,验证码有效时间为两分钟!");
        /**邮件标题*/
        message.setSubject("邮箱验证");

        Transport tranTest = session.getTransport();
        tranTest.connect("smtp.qq.com", 587, "398589287@qq.com", "tdzsicsulffxbhhd");
        tranTest.sendMessage(message, new Address[]{new InternetAddress(email)});
        checkcodeDao.save(new CheckcodeEntity(Util.getUniqueId(),code));
    }
}









