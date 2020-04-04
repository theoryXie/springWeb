package com.example.demo.repository;
import com.example.demo.dao.RefereeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface refereeRepository extends JpaRepository<RefereeEntity,Long> {

    //根据队伍名查询裁判
    @Query(value = "SELECT * FROM referee WHERE referee_id = " +
            "(SELECT team_referee FROM team WHERE team_name = :team_name)", nativeQuery = true)
    RefereeEntity findRefereeByTeam(@Param("team_name") String team_name);
}
