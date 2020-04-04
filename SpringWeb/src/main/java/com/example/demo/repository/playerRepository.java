package com.example.demo.repository;

import com.example.demo.dao.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface playerRepository extends JpaRepository<PlayerEntity,Integer> {

    //根据队伍id查询队伍内所有运动员的信息
    @Query(value = "SELECT * FROM player WHERE player_team = :team_id",nativeQuery = true)
    List<Object> findPlayersByTeam(@Param("team_id") short team_id);



    //根据队伍id按年龄段查询运动员信息
    @Query(value = "SELECT * FROM player WHERE player_team = :team_id " +
            "AND player_age BETWEEN :player_age AND :player_age+1",nativeQuery = true)
    List<Object> findPlayersByTeamAndAge(@Param("team_id") short team_id,
                                               @Param("player_age") short player_age);


    //根据队伍id和姓名查询运动员的信息
    @Query(value = "SELECT * FROM player WHERE player_team = :team_id " +
            "AND player_name = :player_name", nativeQuery = true)
    List<Object> findPlayersByTeamAndName(@Param("team_id") short team_id,
                                                @Param("player_name") String player_name);

    //根据队伍id和姓名查询运动员的信息
    @Query(value = "SELECT * FROM player WHERE player_team = :team_id " +
            "AND player_name = :player_name", nativeQuery = true)
    PlayerEntity findPlayersByTeamAndName_2(@Param("team_id") short team_id,
                                          @Param("player_name") String player_name);

    //根据队伍id和姓名查询运动员的信息
    @Query(value = "SELECT player_id FROM player WHERE player_team = :team_id " +
            "AND player_name = :player_name", nativeQuery = true)
    int getIdByName(@Param("team_id") short team_id,
                                          @Param("player_name") String player_name);
}
