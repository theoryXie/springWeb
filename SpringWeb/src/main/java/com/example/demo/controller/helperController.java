package com.example.demo.controller;

import com.example.demo.dao.CoachEntity;
import com.example.demo.dao.DoctorEntity;
import com.example.demo.dao.LeaderEntity;
import com.example.demo.dao.RefereeEntity;
import com.example.demo.service.gymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ Author     ：Theory.
 * @ Date       ：Created in 15:18 2019/4/2
 * @ Description：随队人员控制类
 * @ Modified By：
 * @Version: $
 */

@RestController
@RequestMapping(value = "/helper")
public class helperController {

    @Autowired
    gymService gymService;


    //通过队伍名查询领队信息
    @GetMapping(value = "/leader/{team_name}")
    public LeaderEntity getLeaderByTeamName(@PathVariable("team_name") String team_name){
        return gymService.findLeaderByTeam(team_name);
    }

    @ResponseBody
    @PostMapping(value = "/leader/{team_name}")
    public void insertCoach(@PathVariable String team_name,@RequestBody LeaderEntity leader){
        gymService.insertLeader(leader,team_name);
    }


    //通过队伍名查询教练信息
    @GetMapping(value = "/coach/{team_name}")
    public CoachEntity getCoachByTeamName(@PathVariable("team_name") String team_name){
        return gymService.findCoachByTeam(team_name);
    }

    //向教练表中插入数据
    @ResponseBody
    @PostMapping(value = "/coach/{team_name}")
    public void insertCoach(@RequestBody CoachEntity coach,@PathVariable String team_name){
        gymService.insertCoach(coach,team_name);
    }

    //更新教练表中数据
    @ResponseBody
    @PutMapping(value = "/coach")
    public boolean updateCoach(@RequestBody CoachEntity coach){
        return gymService.updateCoach(coach);
    }

    //通过队伍名查询裁判信息
    @GetMapping(value = "/referee/{team_name}")
    public RefereeEntity getRefereeByTeamName(@PathVariable("team_name") String team_name){
        return gymService.findRefereeByTeam(team_name);
    }

    @ResponseBody
    @PostMapping(value = "/referee/{team_name}")
    public void inserReferee(@RequestBody RefereeEntity referee, @PathVariable String team_name){
        gymService.insertReferee(referee,team_name);
    }

    //通过队伍名查询队医信息
    @GetMapping(value = "/doctor/{team_name}")
    public DoctorEntity getDoctorByTeamName(@PathVariable("team_name") String team_name){
        return gymService.findDoctorByTeam(team_name);
    }

    @ResponseBody
    @PostMapping(value = "/doctor/{team_name}")
    public void insertDoctor(@RequestBody DoctorEntity doctor,@PathVariable String team_name){
        gymService.insertDoctor(doctor,team_name);
    }
}
