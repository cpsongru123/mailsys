package com.test;

import com.pltm.config.RootConfig;
import com.pltm.config.WebMailSysInitializer;
import com.pltm.config.WebMvcConfig;
import com.pltm.dao.MailHostMapper;
import com.pltm.dao.MailMapper;
import com.pltm.dao.UserMapper;
import com.pltm.dto.*;
import com.pltm.service.MailBindService;
import com.pltm.service.MailRecvService;
import com.pltm.service.MailSendService;
import com.pltm.service.UserService;
import com.pltm.service.impl.MailBindServiceImpl;
import com.pltm.util.MailUtil;
import com.pltm.util.RecvMailMsgHandler;
import com.pltm.vo.MailMessage;
import com.pltm.vo.SendInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebMvcConfig.class)
})
public class TestConn{
    @Autowired
    WebApplicationContext wac;

    @Autowired
    UserMapper userMapper;

    @Autowired
    MailMapper mailMapper;

    @Autowired
    MailHostMapper mailHostMapper;

    @Autowired
    MailBindService mailBindService;

    @Autowired
    MailSendService mailSendService;

    @Autowired
    MailRecvService mailRecvService;

//    @Test
//    public void test_recv_mail() throws Exception {
//        Mail mail = mailMapper.selectByPrimaryKey(1);
//        MailHostExample mailHostExample = new MailHostExample();
//        mailHostExample.createCriteria().andHostNameEqualTo(mail.getMailHostName());
//        MailHost mailHost = mailHostMapper.selectByExample(mailHostExample).get(0);
//        Store store = MailUtil.getStore(mailHost);
//        Message[] messages = mailRecvService.getMessages(mail,store);
//
//        List<MailMessage> mailMessages = null;
//        try {
//            StringBuffer context = new StringBuffer();
//            RecvMailMsgHandler.getMailContent((Part)messages[106],context);
//            mailMessages = mailRecvService.getMailMessageVO(messages,100,107);
//            for(MailMessage msg:mailMessages){
//                System.out.println(msg.toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("mailid out of bound!");
//        }
//    }
//
//    @Test
//    public void test_get_attach(){
//        Multipart multipart = new MimeMultipart();
//        ArrayList<String> attachments = new ArrayList<String>();
//        attachments.add("F:\\attachments\\ee.jpg");
//        MailUtil.getAttachments(multipart,attachments);
//    }
//
//    @Test
//    public void test_mail_send(){
//        Mail mail = mailMapper.selectByPrimaryKey(1);
//        SendInfo sendInfo = new SendInfo();
//        sendInfo.setEmail_from(mail.getMailAcc());
//        sendInfo.setEmail_recipientTo("a991521558@gmail.com");
//        sendInfo.setEmail_content("email content....");
//        sendInfo.setEmail_subject("sssubj");
//        ArrayList<String> attachments = new ArrayList<String>();
//        attachments.add("F:\\attachments\\ee.jpg");
//        sendInfo.setEmail_attachments(attachments);
//        MimeMessage message = mailSendService.createMimeMessage(sendInfo);
//        boolean result = mailSendService.send(message);
//        System.out.println("send result:"+result);
//    }
//
//
//    @Test
//    public void test_bind(){
//        Mail mail = new Mail();
//        mail.setMailAcc("13926032163@163.com");
//        mail.setMailAuth("201475lxr");
//        mail.setMailHostName("email163");
//        mail.setUsername("test");
//        int bind_result = mailBindService.bind(mail);
//        System.out.println("bind result:"+bind_result);
//    }
//
//    @Test
//    public void test_gereric(){
//        MailHost mailHost = mailHostMapper.selectByPrimaryKey(1);
//        Store store = MailUtil.getStore(mailHost);
//        Mail mail = mailMapper.selectByPrimaryKey(1);
//        Folder folder = MailUtil.getFolder(mail, store);
//        Message message = mailRecvService.getSingleMessage(mail,store,109);
//        MailMessage mailMessage = RecvMailMsgHandler.toMailMessage(message);
//        System.out.println("mailMessage:"+mailMessage);
//        StringBuffer files = new StringBuffer();
//        RecvMailMsgHandler.getFile(message,files);
//        System.out.println("files:"+files.toString());
//    }


}
