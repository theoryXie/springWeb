package com.example.demo.repository;

import com.example.demo.dao.FirstmatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface firstMatchRepository  extends JpaRepository<FirstmatchEntity,String> {


    @Query(value ="SELECT first_id From firstmatch WHERE first_sex = ?2 AND first_name  = ?1 AND first_age  = ?3" ,nativeQuery = true)
    String findFirstId(String _name,String sex,short age);
}
