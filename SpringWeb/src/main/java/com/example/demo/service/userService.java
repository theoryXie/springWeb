package com.example.demo.service;

import com.example.demo.dao.TeamEntity;
import com.example.demo.repository.teamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：Theory.
 * @ Date       ：Created in 10:57 2019/3/30
 * @ Description：用户信息服务类
 * @ Modified By：
 * @Version: $
 */

@Service
public class userService {

    @Autowired
    teamRepository teamRepository;

    private final Logger logger = LoggerFactory.getLogger(userService.class);

    //队伍登陆
    public boolean login(String user, String password){
        String pass = teamRepository.findPassByTeamAccount(user);
        if(password.equals(pass)){
            logger.info(user+"登陆成功！");
            return true;
        }
        else {
            logger.info("登陆失败！");
            return false;
        }
    }

    //若登陆正确，根据账号获取队伍信息
    public TeamEntity findTeamByAccount(String team_account){
        logger.info("查询：根据账号获取队伍信息");
        return teamRepository.findTeamByAccount(team_account);
    }
}
