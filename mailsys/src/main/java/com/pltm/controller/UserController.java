package com.pltm.controller;

import com.pltm.dto.Mail;
import com.pltm.dto.User;
import com.pltm.service.MailBindService;
import com.pltm.service.MailSendService;
import com.pltm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailBindService mailBindService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, HttpSession session){
        System.out.println("username:"+user.getUsername());
        int loginResult = userService.login(user);
        if(loginResult>0){
            session.setAttribute("user",user);

            if(user.getUsername().equals("admin")){
                List<User> users = userService.findAllUser();
                session.setAttribute("users",users);
                return "listuser";
            }
            List<Mail> bindList = mailBindService.mailBindCount(user.getUsername());
            session.setAttribute("bindlist",bindList);
            return "showbind";
        }
        return "home";
    }

    @RequestMapping(value = "/update")
    public @ResponseBody String update(User user){
        System.out.println(printUtil(user));
        userService.update(user);
        User newUser = userService.findUserByName(user.getUsername());
        System.out.println(printUtil(newUser));
        return "test update<br>"+printUtil(user)+"<br>"+printUtil(newUser);

    }

    @RequestMapping("/add")
    public String add(User user, HttpServletRequest req){
        System.out.println("test add");
        Integer result = userService.addUser(user);
        User newUser = userService.findUserByName(user.getUsername());
        req.setAttribute("user",newUser);
        return "home";
    }


    @RequestMapping("/delete")
    public @ResponseBody String delete(String username){
        List<User> before = userService.findAllUser();
        StringBuffer stb = new StringBuffer();
        stb.append("test delete<br>").append("before del<br>");
        for(User u:before){
            stb.append(printUtil(u));
        }
        int delid = userService.deleteByName(username);
        System.out.println("delid:"+delid);
        List<User> after = userService.findAllUser();
        stb.append("after del:<br>");
        for(User u:after){
            stb.append(printUtil(u));
        }
        return stb.toString();
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        if(session.getAttribute("user")!=null){
            session.removeAttribute("user");
        }
        return "home";
    }

    public static String printUtil(User u){
        StringBuffer stb = new StringBuffer();
        stb.append("username:").append(u.getUsername()).append("\tnickname:")
                .append(u.getNickname()).append("user_pic:").append(u.getUserPic())
                .append("<br>");
        return stb.toString();
    }
}
