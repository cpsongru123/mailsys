package com.pltm.controller;

import com.pltm.dto.Mail;
import com.pltm.dto.User;
import com.pltm.service.MailBindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MailBindController {
    @Autowired
    MailBindService mailBindService;

    @RequestMapping("/bind")
    public @ResponseBody String bind(HttpServletRequest req, HttpServletResponse reqp,Mail mail){
        System.out.println("binding...");
        if(mail==null)
            return "something wrong";
        System.out.println("bind username: "+mail.getUsername());
        System.out.println("bind mailAcc: "+mail.getMailAcc());
        System.out.println("bind mailAuth: "+mail.getMailAuth());
        System.out.println("bind hostName:"+mail.getMailHostName());
        int result = mailBindService.bind(mail);
        if(result==0){
            System.out.println("bind succeeded");
            return "绑定成功";
        }
        System.out.println("绑定失败");
        return "bind failed";
    }

    @RequestMapping("/unbind")
    public @ResponseBody String unbind(Integer id){
        System.out.println("id:"+id);
        int result = mailBindService.unbind(id);
        if(result==0){
            System.out.println("unbind succeeded");
            return "unbind succeeded";
        }
        System.out.println("unbind failed");
        return "unbind failed";
    }

    @RequestMapping("/showbind")
    public String showBind(HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user==null)
            return "home";
        List<Mail> mailList = mailBindService.mailBindCount(user.getUsername());
        session.setAttribute("bindlist",mailList);
        return "showbind";
    }


}
