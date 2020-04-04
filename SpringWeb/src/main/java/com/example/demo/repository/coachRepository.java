package com.example.demo.repository;

import com.example.demo.dao.CoachEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface coachRepository extends JpaRepository<CoachEntity, Integer> {

    //根据队伍名查询教练
    @Query(value = "SELECT * FROM coach WHERE coach_id = " +
            "(SELECT team_coach FROM team WHERE team_name = :team_name)", nativeQuery = true)
    CoachEntity findCoachByTeam(@Param("team_name") String team_name);

    //向教练表中插入教练
    @Query(value="INSERT INTO coach(coach_name, coach_idcard, coach_phone, coach_sex) VALUES(?coach_name,?coach_idcard,?coach_phone,?coach_sex)",nativeQuery = true)
    int insertCoach( String coach_name, String coach_idcard, String coach_phone, String coach_sex);

    //更新教练表中数据
    @Modifying
    @Query(value = "UPDATE coach SET coach_name=:coach_name,SET coach_idcard=:coach_idcard," +
            "SET coach_phone=:coach_phone,SET coach_sex=:coach_sex WHERE coach_id=:coach_id",nativeQuery = true)
    boolean updateCoach(@Param("coach_id") short coach_id,
                        @Param("coach_name") String coach_name,
                        @Param("coach_idcard") String coach_idcard,
                        @Param("coach_phone") String coach_phone,
                        @Param("coach_sex") String coach_sex
    );


}
