package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ Author     ：Theory.
 * @ Date       ：Created in 16:53 2019/3/29
 * @ Description：体操赛事服务类
 * @ Modified By：
 * @Version: $
 */

@Service
public class gymService {

    @Autowired
    playerRepository playerRepository;

    @Autowired
    teamRepository teamRepository;

    @Autowired
    LeaderRepository leaderRepository;

    @Autowired
    coachRepository coachRepository;

    @Autowired
    refereeRepository refereeRepository;

    @Autowired
    doctorRepository doctorRepository;

    @Autowired
    firstPlayRepository firstPlayRepository;

    @Autowired
    firstMatchRepository firstMatchRepository;

    private final Logger logger = LoggerFactory.getLogger(gymService.class);


    //根据队伍名和条件查找队里运动员
    public List<Object> findPlayersByTeam(String team_name,String type,String info){

        short team_id = teamRepository.findTeamIdByName(team_name);

        //查询全部
        if(type.equals("all")){
            logger.info("查询：根据队伍id查询全部队伍内的运动员");
            return playerRepository.findPlayersByTeam(team_id);
        }

        //按年龄段查询
        if(type.equals("age")){
            logger.info("查询：根据队伍id和年龄查询特定年龄段的运动员");
            short shortInfo = Short.parseShort(info);
            return playerRepository.findPlayersByTeamAndAge(team_id,shortInfo);
        }

        //按照姓名查询
        if(type.equals("name")){
            logger.info("查询：根据队伍id和姓名查询运动员");
            return playerRepository.findPlayersByTeamAndName(team_id, info);
        }

        if(type.equals("match_num")){
            logger.info("查询：查询最少参加了"+info+"项比赛的运动员");
            return firstPlayRepository.findPlayerByMatchNum(Integer.parseInt(info));
        }

        return null;
    }

    //向运动员表里插入运动员
    public PlayerEntity insertPlayers(PlayerEntity playerEntity){
        logger.info("插入：向运动员表里插入运动员信息");
        return playerRepository.save(playerEntity);
    }

    //根据队伍名查询领队
    public LeaderEntity findLeaderByTeam(String teamName){
        logger.info("查询：查询领队");
        return leaderRepository.findLeaderByTeam(teamName);
    }

    //向领队表中插入数据
    @Transactional
    public void insertLeader(LeaderEntity leader, String team_name){
        leaderRepository.save(leader);
        teamRepository.updateTeamLeader(leader.getLeaderId(),team_name);
    }


    //根据队伍名查询教练
    public CoachEntity findCoachByTeam(String teamName){
        logger.info("查询：查询教练");
        return coachRepository.findCoachByTeam(teamName);
    }

    //向教练表中插入数据
    @Transactional
    public void insertCoach(CoachEntity coach, String team_name){
        coachRepository.save(coach);
        teamRepository.updateTeamCoach(coach.getCoachId(),team_name);
    }

    //更新教练表中数据
    public boolean updateCoach(CoachEntity coach){
        return coachRepository.updateCoach(coach.getCoachId(),coach.getCoachName(),coach.getCoachIdcard(),
                coach.getCoachPhone(),coach.getCoachSex());
    }

    //根据队伍名查询裁判
    public RefereeEntity findRefereeByTeam(String teamName){
        logger.info("查询：查询裁判");
        return refereeRepository.findRefereeByTeam(teamName);
    }

    //向裁判中插入数据
    @Transactional
    public void insertReferee(RefereeEntity referee, String team_Name){
        refereeRepository.save(referee);
        teamRepository.updateTeamReferee(referee.getRefereeId(),team_Name);
    }

    //根据队伍名查询队医
    public DoctorEntity findDoctorByTeam(String teamName){
        logger.info("查询：查询队医");
        return doctorRepository.findDoctorByTeam(teamName);
    }

    //向队医表中插入数据
    @Transactional
    public void insertDoctor(DoctorEntity doctor, String team_name){
        doctorRepository.save(doctor);
        teamRepository.updateTeamDoctor(doctor.getDoctorId(),team_name);
    }



    //通过运动员姓名和条件查询相关信息
    public List<Object> findInfoByPlayerAndType(String type,String playerName){

        if(type.equals("match")){
            logger.info("查询 "+playerName+" 的比赛信息");
            return firstPlayRepository.findMatchByPlayer(playerName);
        }
        return null;
    }


    //根据条件和比赛信息查询相关信息
    public List<Object> getMatchInfoByType(String type0,String type1,String type2,String type3,String info){

        //根据比赛信息查询该比赛排名
        if(type0.equals("rank")){
            if(info==null){ //查询全部排名（从高到低）
                logger.info("查询"+type1+type2+type3+"排名");
                return firstPlayRepository.getMatchInfoByType(type1,Short.parseShort(type2),type3);
            }
            else{

            }
        }
        return null;
    }

    //参赛报名

    public void register(String teanName, String playerName, String matchName){
        short team_id = teamRepository.findTeamIdByName(teanName);
        PlayerEntity playerEntity=(playerRepository.findPlayersByTeamAndName_2(team_id,playerName));


        String first_id = firstMatchRepository.findFirstId(matchName,playerEntity.getPlayerSex(),playerEntity.getPlayerAge());

        FirstPlayEntity firstPlayEntity = new FirstPlayEntity();
        firstPlayEntity.setPlayId(playerEntity.getPlayerId());
        firstPlayEntity.setFirstId(first_id);
        firstPlayRepository.save(firstPlayEntity);

    }
}
