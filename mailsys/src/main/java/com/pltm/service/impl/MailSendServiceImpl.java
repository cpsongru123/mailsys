package com.pltm.service.impl;

import com.pltm.dao.MailHostMapper;
import com.pltm.dao.MailMapper;
import com.pltm.dto.Mail;
import com.pltm.dto.MailExample;
import com.pltm.dto.MailHost;
import com.pltm.dto.MailHostExample;
import com.pltm.service.MailSendService;
import com.pltm.util.MailUtil;
import com.pltm.vo.SendInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@Service
public class MailSendServiceImpl implements MailSendService {

    @Autowired
    MailHostMapper mailHostMapper;

    @Autowired
    MailMapper mailMapper;

    public boolean send(MimeMessage mimeMessage) {
        try {
            Transport.send(mimeMessage);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("sending email err in MailSendService.send");
        }
        return false;
    }

    public MimeMessage createMimeMessage(SendInfo sendInfo) {

        //get MailHostInfo
        MailHostExample example = new MailHostExample();
        MailHost mailHost = mailHostMapper.selectByExample(example).get(0);

        //get Mail by sendFrom
        MailExample example1 = new MailExample();
        example1.createCriteria().andMailAccEqualTo(sendInfo.getEmail_from());
        Mail mail = mailMapper.selectByExample(example1).get(0);
        //get SMTP Session
        Session session = MailUtil.getSmtpSession(mail,mailHost);

        //create MimeMessage, a SMTP Session required
        MimeMessage message = new MimeMessage(session);
        try {
            //set email subject
            message.setSubject(sendInfo.getEmail_subject());

            //set email sender
            message.setFrom(new InternetAddress(sendInfo.getEmail_from()));

            //set email receivers, can be multi people
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendInfo.getEmail_recipientTo()));

            //create multipart, type is mixed(assume it contails attachments
            Multipart multipart = new MimeMultipart("mixed");

            //get all attachments if there are any
            if(sendInfo.getEmail_attachments()!=null){
                if(sendInfo.getEmail_attachments().size()>0){
                    System.out.println("adding attachments...");
                    multipart = MailUtil.getAttachments(multipart,sendInfo.getEmail_attachments());
                }
            }
            //create email content
            BodyPart contentBodyPart = new MimeBodyPart();

            //set  email content
            contentBodyPart.setContent(sendInfo.getEmail_content(),"text/html;charset=UTF-8");
            multipart.addBodyPart(contentBodyPart);

            message.setContent(multipart);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("MimeMessage setup error in MailSendService.createMimeMessage");
        }
        return message;
    }

}
