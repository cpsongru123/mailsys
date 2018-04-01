package com.pltm.service;


import com.pltm.dto.Mail;
import com.pltm.dto.User;

import java.util.List;


public interface UserService {

    /***
     * 登陆
     * @param user
     * @return
     */
    int login(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    int deleteById(int id);


    /**
     * 根据用户名删除用户
     * @param name
     * @return
     */
    int deleteByName(String name);

    /**
     * 通过id查找用户
     * @param id
     * @return
     */


    User findUserById(int id);

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    User findUserByName(String username);

    /**
     * 查找所有用户
     * @return
     */
    List<User> findAllUser();

    /**
     * 查找所有绑定邮箱
     * @return
     */
    List<Mail> findAllBind();

    /**
     * 根据id删除绑定邮箱
     * @param id
     * @return
     */
    int delBind(int id);

    /**
     * 用户注册
     * @param user
     * @return
     */
    int addUser(User user);

}
