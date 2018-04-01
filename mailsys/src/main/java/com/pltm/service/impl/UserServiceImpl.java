package com.pltm.service.impl;

import com.pltm.dao.MailMapper;
import com.pltm.dao.UserMapper;
import com.pltm.dto.Mail;
import com.pltm.dto.MailExample;
import com.pltm.dto.User;
import com.pltm.dto.UserExample;
import com.pltm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailMapper mailMapper;


    public int login(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername())
                .andPasswordEqualTo(user.getPassword());
        List<User> result = userMapper.selectByExample(example);
        return result.size();
    }


    public int update(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername());

        return userMapper.updateByExample(user,example);
    }


    public int deleteById(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public int deleteByName(String name) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(name);
        return userMapper.deleteByExample(example);
    }


    public User findUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }


    public User findUserByName(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> result = null;
        result = userMapper.selectByExample(example);
        return result==null?null:result.get(0);
    }



    public List<User> findAllUser() {
        UserExample example = new UserExample();
        example.createCriteria().andIdIsNotNull();
        List<User> result = userMapper.selectByExample(example);
        return result;
    }

    public List<Mail> findAllBind() {
        MailExample example = new MailExample();
        example.createCriteria().andIdIsNotNull();
        return mailMapper.selectByExample(example);
    }

    public int delBind(int id) {
        return mailMapper.deleteByPrimaryKey(id);
    }

    public int addUser(User user) {
        return userMapper.insert(user);
    }
}
