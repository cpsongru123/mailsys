package com.pltm.controller;

import com.pltm.dao.MailMapper;
import com.pltm.dto.Mail;
import com.pltm.dto.MailExample;
import com.pltm.service.MailSendService;
import com.pltm.util.FileSaveUtil;
import com.pltm.util.RecvMailMsgHandler;
import com.pltm.vo.MailMessage;
import com.pltm.vo.SendInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.resources.Messages;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MailSendController {
    @Autowired
    MailSendService mailSendService;

    @Autowired
    MailMapper mailMapper;


    @RequestMapping("/forword")
    public String forword(@RequestParam Integer id,HttpServletRequest req, HttpSession session){
        System.out.println("id: "+id);
        Message[] message = (Message[])session.getAttribute("allmessages");
        MailMessage mailMessage = RecvMailMsgHandler.toMailMessage(message[id-1]);
        System.out.println("getMailMessage:"+mailMessage);
        req.setAttribute("forwordmsg",mailMessage);
        return "forword";
    }

    @RequestMapping("/reply")
    public String reply(@RequestParam Integer id, HttpServletRequest req,HttpSession session){
        System.out.println("id: "+id);
        Message[] message = (Message[])session.getAttribute("allmessages");
        MailMessage mailMessage = RecvMailMsgHandler.toMailMessage(message[id-1]);
        String replyfrom = RecvMailMsgHandler.getFromAddr(message[id-1]);
        System.out.println("replyfrom: "+replyfrom);
        session.setAttribute("replyfrom",replyfrom);
        System.out.println("getMailMessage:"+mailMessage);
        req.setAttribute("replymsg",mailMessage);
        return "reply";
    }

    @RequestMapping("/send")
    public @ResponseBody String send(@RequestParam(required=false)MultipartFile file, SendInfo sendInfo){

        String oriFileName = file.getOriginalFilename();
        String savedFile = null;
        if(!oriFileName.equals("")){
            byte[] bytes = null;
            try {
                bytes = file.getBytes();
                savedFile =  FileSaveUtil.saveFiletoBaseDir(oriFileName,bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(savedFile!=null){
            ArrayList<String> attachments = new ArrayList<String>();
            attachments.add(savedFile);
            sendInfo.setEmail_attachments(attachments);
        }



        if(file!=null){
            System.out.println(file.getOriginalFilename());
        }
        if(sendInfo==null){
            System.out.println("sendInfo is null");
            return "failed";

        }
        else {
            System.out.println(sendInfo.toString());
        }


        MimeMessage message = mailSendService.createMimeMessage(sendInfo);
        boolean result = mailSendService.send(message);
        if(result)
            System.out.println("发送成功");
        else {
            System.out.println("发送失败");
        }
        return "ok";
    }

    @RequestMapping("/presend")
    public String presend(){
        return "sendmail";
    }
}
