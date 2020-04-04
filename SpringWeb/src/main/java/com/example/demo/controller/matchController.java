package com.example.demo.controller;

import com.example.demo.service.gymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Author     ：Theory.
 * @ Date       ：Created in 15:19 2019/4/2
 * @ Description：比赛控制类
 * @ Modified By：
 * @Version: $
 */

@RestController
@RequestMapping(value = "/match")
public class matchController {


    @Autowired
    gymService gymService;


    //根据条件和比赛信息查询相关信息
    @GetMapping()
    public List<Object> getMatchInfoByType(@RequestParam String type0,
                                           @RequestParam String type1,
                                           @RequestParam String type2,
                                           @RequestParam String type3,
                                           @RequestParam(required = false) String info){
        return gymService.getMatchInfoByType(type0,type1,type2,type3,info);
    }


    @PostMapping()
    public void register(@RequestParam String teamName,
                            @RequestParam String playerName,
                            @RequestParam String matchName){
        gymService.register(teamName,playerName,matchName);
    }

}
