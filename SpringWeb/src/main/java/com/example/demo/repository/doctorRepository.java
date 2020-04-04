package com.example.demo.repository;

import com.example.demo.dao.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface doctorRepository extends JpaRepository<DoctorEntity,Long> {

    //根据队伍名查询队医
    @Query(value = "SELECT * FROM doctor WHERE doctor_id = " +
            "(SELECT team_doctor FROM team WHERE team_name = :team_name)", nativeQuery = true)
    DoctorEntity findDoctorByTeam(@Param("team_name") String team_name);
}
