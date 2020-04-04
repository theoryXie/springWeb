package com.example.demo.controller;

import com.example.demo.dao.*;
import com.example.demo.service.gymService;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @ Author     ：Theory.
 * @ Date       ：Created in 16:41 2019/3/29
 * @ Description：体操管理类
 * @ Modified By：
 * @Version: $
 */

@RestController
@RequestMapping(value = "/gym")
public class gymController {

    @Autowired
    gymService gymService;

    @Autowired
    userService userService;

    //根据用户名获取队伍信息
    @GetMapping()
    public TeamEntity findTeamByAccount(@RequestParam String team_account){
        return userService.findTeamByAccount(team_account);
    }



}
