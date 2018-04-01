package com.pltm.service;

import com.pltm.dto.Mail;

import java.util.List;

public interface MailBindService {

    /**
     * 绑定邮箱
     * @param mail
     * @return
     * 返回0为绑定成功
     */
    int bind(Mail mail);


    int unbind(Integer id);

    /**
     * 查询用户绑定的所有邮箱
     * @param username
     * @return
     */
    List<Mail> mailBindCount(String username);
}
