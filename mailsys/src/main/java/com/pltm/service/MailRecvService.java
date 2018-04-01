package com.pltm.service;

import com.pltm.dto.Mail;
import com.pltm.vo.MailMessage;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Store;
import java.util.List;

public interface MailRecvService {




    Message[] getMessages(String mailAcc) throws Exception;

    Message[] getMessages(String mailAcc, int start, int end) throws Exception;

    Message[] getMessages(Mail mail, Store store) throws Exception;

    /**
     * 获取邮件消息
     * @param mail
     * @param store
     * @param start 邮件起始id，从1开始
     * @param end 邮件结束id, 最大值为getMessageCount返回的值
     * @return
     * @throws Exception
     */
    Message[] getMessages(Mail mail, Store store, int start, int end) throws Exception;


    /**
     * 获取邮件总数
     * @param folder
     * @return
     */
    int getMessageCount(Folder folder);

    /**
     * 删除邮件
     * @param mailAcc
     * @param msgId
     * @return
     * @throws MessagingException
     */
    boolean delMessage(String mailAcc, int msgId) throws MessagingException;


    /**
     * 根据邮件id获取对应的邮件
     * @param mail
     * @param store
     * @param msgId
     * @return
     */
    Message getSingleMessage(Mail mail, Store store, int msgId);

    Message getSingleMessage(String mailAcc, int msgId);

    /**
     * 获取邮件消息实体，便于在展示邮件
     * @param messages
     * @return
     * @throws Exception
     */
    List<MailMessage> getMailMessageVO(Message[] messages) throws Exception;

    /**
     * 获取指定id之间的邮件消息实体
     * @param messages
     * @param startId
     * @param endId
     * @return
     * @throws Exception
     */
    List<MailMessage> getMailMessageVO(Message[] messages, int startId, int endId) throws Exception;
}
