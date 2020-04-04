package com.example.demo.controller;

import com.example.demo.dao.TeamEntity;
import com.example.demo.service.userService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ Author     ：Theory.
 * @ Date       ：Created in 10:56 2019/3/30
 * @ Description：用户信息操作类
 * @ Modified By：
 * @Version: $
 */

@RestController
@RequestMapping(value = "/user")
public class userController {

    @Autowired
    userService userService;

    String team_account = "";

    //队伍登陆
    @PostMapping(value = "/login")
    public boolean login(@RequestParam String user, @RequestParam String password){
        if(userService.login(user,password)){ //用户名密码正确
            team_account = user;
            return true;
        }
        else {
            return false;
        }
    }


    //获取队伍名
    @GetMapping(value = "/init")
    public JSONObject getTeamName(){
        String temp = "{\"team_account\":\""+team_account+"\"}";
        JSONObject jsonobject = JSONObject.fromObject(temp);
        return jsonobject;
    }



}
