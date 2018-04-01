package com.pltm.controller;

import com.pltm.dto.Mail;
import com.pltm.dto.User;
import com.pltm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UserService userService;


    @RequestMapping("/listuser")
    public String listuser(HttpSession session){
        List<User> users = userService.findAllUser();
        session.setAttribute("users",users);
        return "listuser";
    }

    @RequestMapping("/listbind")
    public String listbind(HttpSession session){
        List<Mail> binds = userService.findAllBind();
        session.setAttribute("binds",binds);
        return "listbind";
    }

    @RequestMapping("/deluser")
    public @ResponseBody String deluser(@RequestParam Integer id){
        System.out.println("del user ,id: "+id);
        userService.deleteById(id);
        return "deluser id: "+id+" succeeded";
    }

    @RequestMapping("/delbind")
    public  @ResponseBody String delbind(@RequestParam Integer id){
        System.out.println("del bind, id: "+id);
        userService.delBind(id);
        return "del mail id: "+id+" succeeded";
    }
}
