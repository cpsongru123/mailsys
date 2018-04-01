package com.pltm.service.impl;

import com.pltm.dao.MailHostMapper;
import com.pltm.dao.MailMapper;
import com.pltm.dto.Mail;
import com.pltm.dto.MailExample;
import com.pltm.dto.MailHost;
import com.pltm.dto.MailHostExample;
import com.pltm.service.MailRecvService;
import com.pltm.util.MailUtil;
import com.pltm.util.RecvMailMsgHandler;
import com.pltm.vo.MailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class MailRecvServiceImpl implements MailRecvService{

    @Autowired
    MailMapper mailMapper;

    @Autowired
    MailHostMapper mailHostMapper;


    /**
     * 通过邮箱号获取邮箱绑定信息
     * @param mailAcc
     * @return
     */
    private Mail getMailByMailAcc(String mailAcc){
        MailExample mailExample = new MailExample();
        mailExample.createCriteria().andMailAccEqualTo(mailAcc);
        return mailMapper.selectByExample(mailExample).get(0);
    }

    /**
     * 通过邮箱号获取邮件服务器信息
     * @param mailAcc
     * @return
     */
    private MailHost getMailHostByMailAcc(String mailAcc){
        Mail mail = getMailByMailAcc(mailAcc);
        MailHostExample mailHostExample = new MailHostExample();
        mailHostExample.createCriteria().andHostNameEqualTo(mail.getMailHostName());
        return mailHostMapper.selectByExample(mailHostExample).get(0);
    }

    public Message[] getMessages(String mailAcc) throws Exception {
        Store store = MailUtil.getStore(getMailHostByMailAcc(mailAcc));
        Folder folder = MailUtil.getFolder(getMailByMailAcc(mailAcc),store);
        return getMessages(mailAcc,1,getMessageCount(folder));
    }

    public Message[] getMessages(String mailAcc, int start, int end) throws Exception {
        Store store = MailUtil.getStore(getMailHostByMailAcc(mailAcc));
        return getMessages(getMailByMailAcc(mailAcc), store, start, end);
    }

    public Message[] getMessages(Mail mail, Store store) throws Exception {
        Folder folder = MailUtil.getFolder(mail,store);
        int msgCount = getMessageCount(folder);
        return getMessages(mail,store,1,msgCount);
    }

    public Message[] getMessages(Mail mail, Store store, int start, int end) throws Exception {

        Folder folder = MailUtil.getFolder(mail, store);
        MailUtil.openFolder(folder,Folder.READ_WRITE);
        if(start<1||end>folder.getMessageCount())
            throw new Exception("msg index out of bound!");
        Message[] messages = null;
        try {
            messages = folder.getMessages(start,end);
            System.out.println("message count: "+folder.getMessageCount());
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("err in MailRecvService.getMessages, folder.getMessages failed to execurte");
        }
        return messages;
    }

    public int getMessageCount(Folder folder) {
        MailUtil.openFolder(folder,Folder.READ_WRITE);
        int result = -1;
        try{
            result = folder.getMessageCount();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delMessage(String mailAcc, int msgId) throws MessagingException {
        Message message = getSingleMessage(mailAcc,msgId);
        message.setFlag(Flags.Flag.DELETED,true);
        if(message.isSet(Flags.Flag.DELETED)){
            System.out.println("msg "+msgId+" deleted");
            return true;
        }
        return false;
    }


    public Message getSingleMessage(Mail mail, Store store, int msgId) {
        Folder folder = MailUtil.getFolder(mail,store);
        MailUtil.openFolder(folder,Folder.READ_WRITE);
        Message message = null;
        try {
            if(msgId<1||msgId>folder.getMessageCount()){
                System.out.println("msgId out of bound!");
                return null;
            }
            message = folder.getMessage(msgId);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return message;
    }

    public Message getSingleMessage(String mailAcc, int msgId) {
        Mail mail = getMailByMailAcc(mailAcc);
        Store store = MailUtil.getStore(getMailHostByMailAcc(mailAcc));
        return getSingleMessage(mail,store,msgId);
    }


    public List<MailMessage> getMailMessageVO(Message[] messages) throws Exception {
        return getMailMessageVO(messages,0,messages.length);
    }

    public List<MailMessage> getMailMessageVO(Message[] messages, int startId, int endId) throws Exception {
        ArrayList<MailMessage> result = new ArrayList<MailMessage>();
        System.out.println("messages length: "+messages.length);
        if(startId<0||endId>messages.length){
            throw new Exception("mailMsgId out out bound ");
        }
        for(int i=startId; i<endId; i++){
            MailMessage mailMsg = new MailMessage();
            mailMsg.setMailMsgFrom(RecvMailMsgHandler.getFromName(messages[i]));
            mailMsg.setMailMsgSubject(messages[i]==null?"":messages[i].getSubject());
            mailMsg.setMailMsgDate(RecvMailMsgHandler.getSendData(messages[i]));
            StringBuffer context = new StringBuffer();
            context = RecvMailMsgHandler.getMailContent(messages[i],context);
            mailMsg.setMailMsgContent(context.toString());
            mailMsg.setMailMsgId(messages[i].getMessageNumber());
            result.add(mailMsg);
        }
        return result;
    }
}
