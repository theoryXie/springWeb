package com.example.demo.repository;

import com.example.demo.dao.LeaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LeaderRepository extends JpaRepository<LeaderEntity,Long> {


    //根据队伍名查询领队
    @Query(value = "SELECT * FROM leader WHERE leader_id = " +
            "(SELECT team_leader FROM team WHERE team_name = :team_name)", nativeQuery = true)
    LeaderEntity findLeaderByTeam(@Param("team_name") String team_name);
}
