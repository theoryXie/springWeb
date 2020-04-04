package com.example.demo.repository;

import com.example.demo.dao.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface teamRepository extends JpaRepository<TeamEntity,Integer> {

    //通过队伍名查询队伍id
    @Query(value ="SELECT team_id From team WHERE team_name = :team_name" ,nativeQuery = true)
    short findTeamIdByName(@Param("team_name") String team_name);

    //登陆时查询队伍用户名和密码
    @Query(value = "SELECT team_password FROM team WHERE team_account = :team_account", nativeQuery = true)
    String findPassByTeamAccount(@Param("team_account") String team_account);

    //根据用户名和密码获取队伍信息
    @Query(value = "SELECT * FROM team WHERE team_account = :team_account",nativeQuery = true)
    TeamEntity findTeamByAccount(@Param("team_account") String team_account);

    //更新队伍的领队
    @Modifying
    @Query(value = "UPDATE team SET team_leader = :team_leader WHERE team_name= :team_name", nativeQuery = true)
    void updateTeamLeader(@Param("team_leader") short team_leader,
                          @Param("team_name") String team_name);

    //更新队伍的队医
    @Modifying
    @Query(value = "UPDATE team SET team_doctor = :team_doctor WHERE team_name= :team_name", nativeQuery = true)
    void updateTeamDoctor(@Param("team_doctor") short team_doctor,
                          @Param("team_name") String team_name);

    //更新队伍的裁判
    @Modifying
    @Query(value = "UPDATE team SET team_referee = :team_referee WHERE team_name= :team_name", nativeQuery = true)
    void updateTeamReferee(@Param("team_referee") short team_referee,
                          @Param("team_name") String team_name);

    //更新队伍的教练
    @Modifying
    @Query(value = "UPDATE team SET team_coach = :team_coach WHERE team_name= :team_name", nativeQuery = true)
    void updateTeamCoach(@Param("team_coach") short team_coach,
                          @Param("team_name") String team_name);
}
