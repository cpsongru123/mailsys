package com.pltm.service;

import com.pltm.dto.Mail;
import com.pltm.vo.SendInfo;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public interface MailSendService {

    /**
     * 发送邮件
     * @param mimeMessage
     * @return
     */
    boolean send(MimeMessage mimeMessage);

    /**
     * 创建MineMessage对象，该对象包含要发送的各种邮件信息
     * 如收件人，发件人，邮件主题，邮件内容，附件等
     * @param sendInfo
     * @return
     */
    MimeMessage createMimeMessage(SendInfo sendInfo);

}
