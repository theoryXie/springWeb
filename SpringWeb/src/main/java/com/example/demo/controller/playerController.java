package com.example.demo.controller;

import com.example.demo.dao.PlayerEntity;
import com.example.demo.service.gymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Author     ：Theory.
 * @ Date       ：Created in 15:18 2019/4/2
 * @ Description：运动员控制类
 * @ Modified By：
 * @Version: $
 */

@RestController
@RequestMapping(value = "/player")
public class playerController {

    @Autowired
    gymService gymService;

    //通过队伍名和条件查询队伍内运动员的信息
    @GetMapping(value = "/{team_name}")
    public List<Object> getPlayerByTeamName(@PathVariable("team_name") String team_name,
                                                  @RequestParam String type,
                                                  @RequestParam String info){
        return gymService.findPlayersByTeam(team_name,type,info);
    }


    //向运动员表里插入信息
    @ResponseBody
    @PostMapping()
    public PlayerEntity insertPlayers(@RequestBody PlayerEntity playerEntity){
        return gymService.insertPlayers(playerEntity);
    }


    //通过运动员姓名和条件查询相关信息
    @GetMapping()
    public List<Object> findInfoByPlayerAndType(@RequestParam String type,@RequestParam String playerName){
        return gymService.findInfoByPlayerAndType(type,playerName);
    }
}
