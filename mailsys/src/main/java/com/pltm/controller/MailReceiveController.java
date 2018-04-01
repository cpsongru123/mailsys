package com.pltm.controller;

import com.pltm.dao.MailMapper;
import com.pltm.dto.Mail;
import com.pltm.service.MailRecvService;
import com.pltm.service.MailSendService;
import com.pltm.util.MailUtil;
import com.pltm.util.RecvMailMsgHandler;
import com.pltm.vo.MailMessage;
import com.pltm.vo.SendInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MailReceiveController {

    @Autowired
    MailRecvService mailRecvService;


    @RequestMapping("/selectacc")
    public String selectAcc(HttpSession session){
        String acc = (String) session.getAttribute("acc");

        System.out.println("session acc: "+ acc);
        return "selectpage";
    }

    @RequestMapping("/listmail")
    public String listMail(String mailacc, HttpSession session){
        //
        System.out.println("mailacc: "+mailacc);
        if(null==mailacc){
            mailacc = (String) session.getAttribute("acc");
        }
        Message[] messages = null;
        List<MailMessage> lists = null;
        try {
            messages= mailRecvService.getMessages(mailacc);
            if(messages==null){
                System.out.println("no messages");
            }
            lists = mailRecvService.getMailMessageVO(messages,0,messages.length);
            session.setAttribute("allmessages",messages);
            session.setAttribute("messages",lists);
            session.setAttribute("acc",mailacc);
            session.setAttribute("selectedval",mailacc);
            System.out.println("messages: "+lists);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "listmail";
    }

    @RequestMapping("/maildetail/{msgid}")
    public String mailDetail(HttpSession session,@PathVariable Integer msgid){
        String mailAcc = (String) session.getAttribute("acc");
        System.out.println("mailDetail Controller---------------------");
        System.out.println("acc: "+mailAcc);
        Message message = mailRecvService.getSingleMessage(mailAcc,msgid);
        MailMessage mailMessage = RecvMailMsgHandler.toMailMessage(message);
        System.out.println("mailMessage: "+mailMessage.toString());
        session.setAttribute("mailMessage",mailMessage);
        StringBuffer files = new StringBuffer();
        RecvMailMsgHandler.getFile(message,files);
        System.out.println("generate attachments:"+files.toString());
        session.setAttribute("attachments",files.toString());
        return "maildetail";
    }

    @RequestMapping("/deletemsg")
    public @ResponseBody String delleteMsg(HttpSession session, @RequestParam Integer id){
        System.out.println("msgid to be del: "+id);
        String acc = (String) session.getAttribute("acc");
        System.out.println("acc: "+acc);
        boolean result = false;
        try {
            result = mailRecvService.delMessage(acc,id);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        if(result){
            System.out.println("del succeeded");
            return "del msg "+id+" succeeded";
        }
        return  "del msg "+id+" failed";

    }
}
