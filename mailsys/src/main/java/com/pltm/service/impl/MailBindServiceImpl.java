package com.pltm.service.impl;

import com.pltm.dao.MailHostMapper;
import com.pltm.dao.MailMapper;
import com.pltm.dto.Mail;
import com.pltm.dto.MailExample;
import com.pltm.dto.MailHost;
import com.pltm.dto.MailHostExample;
import com.pltm.service.MailBindService;
import com.pltm.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Store;
import java.util.List;
@Service
public class MailBindServiceImpl implements MailBindService{

    @Autowired
    MailHostMapper mailHostMapper;

    @Autowired
    MailMapper mailMapper;

    public int bind(Mail mail) {
        System.out.println("bind method in bind service invoked!");
        MailHostExample mhExample = new MailHostExample();
        mhExample.createCriteria().andHostNameEqualTo(mail.getMailHostName());
        MailHost mailHost = mailHostMapper.selectByExample(mhExample).get(0);
        System.out.println("egt mailHost:"+mailHost.getHostName());
        Store store = MailUtil.getStore(mailHost);
        System.out.println("get store: "+store);
        boolean result = MailUtil.connect(mail,store);
        if(result){
            //连接成功，将邮箱绑定信息插入数据库
            mailMapper.insert(mail);
            System.out.println("绑定成功，用户名："+mail.getUsername()+"\t邮箱号："
                    +mail.getMailAcc());
            return 0;
        }
        System.out.println("绑定失败!");
        return -1;
    }

    public int unbind(Integer id) {
        int result = mailMapper.deleteByPrimaryKey(id);
        if(result==1){
            return 0;
        }
        return -1;
    }

    public List<Mail> mailBindCount(String username) {
        MailExample example = new MailExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Mail> result = null;
        result = mailMapper.selectByExample(example);
        return result;
    }
}
