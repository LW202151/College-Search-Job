package com.SeventhGroup.CollegeSearchJob.service;


import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

/**
 * @author zjl
 */
@Service
public class EmailService {

   //private Properties props = System.getProperties();


    public void sendEmailByInput(String email) throws MessagingException {
       Properties props = System.getProperties();
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
        /**设置邮件内容*/
        message.setText("你的验证码为："+code+"。请注意,验证码有效时间为两分钟!");
        /**邮件标题*/
        message.setSubject("邮箱验证");

        Transport tranTest = session.getTransport();
        tranTest.connect("smtp.qq.com","398589287@qq.com","tdzsicsulffxbhhd");
        tranTest.sendMessage(message, new Address[]{new InternetAddress(email)});
    }





}
