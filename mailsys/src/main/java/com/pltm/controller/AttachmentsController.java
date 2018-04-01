package com.pltm.controller;

import com.pltm.service.MailRecvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class AttachmentsController {

    @Autowired
    MailRecvService mailRecvService;

    @RequestMapping("/download")
    public void download(HttpSession session, HttpServletRequest req, HttpServletResponse resp,
                         @RequestParam Integer msgNum, @RequestParam Integer bodyNum) throws IOException {
        resp.setContentType("text/html;");

        System.out.println("downloadController--------------------------");
        System.out.println("msgNum: "+msgNum);
        System.out.println("bodyNum: "+bodyNum);
        ServletOutputStream out = resp.getOutputStream();
        try{
            String mailAcc = (String) session.getAttribute("acc");
            System.out.println("acc: "+mailAcc);
            Message message = mailRecvService.getSingleMessage(mailAcc,msgNum);
            Multipart multipart = (Multipart)message.getContent();
            BodyPart bodypart = multipart.getBodyPart(bodyNum);
            String filename = bodypart.getFileName();
            System.out.println("fileName of bodypart: "+filename);


            // 将消息头类型设置为附件类型
            resp.setHeader("Content-Disposition",
                    "attachment;filename=" + filename);
            InputStream input = bodypart.getInputStream();

            int temp = 0;
            while((temp = input.read()) != -1)
            {
                out.write(temp);
            }
            input.close();
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
