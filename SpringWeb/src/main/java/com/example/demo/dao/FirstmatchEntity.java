package com.example.demo.dao;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ Author     ：Theory.
 * @ Date       ：Created in 16:48 2019/3/29
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Entity
@Table(name = "firstmatch", schema = "gym_sys", catalog = "")
public class FirstmatchEntity {
    private String firstId;
    private String firstName;
    private String firstAge;
    private String firstSex;
    private Short registNum;
    private Short playNum;
    private Short scoreNum;

    @Id
    @Column(name = "first_id")
    public String getFirstId() {
        return firstId;
    }

    public void setFirstId(String firstId) {
        this.firstId = firstId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "first_age")
    public String getFirstAge() {
        return firstAge;
    }

    public void setFirstAge(String firstAge) {
        this.firstAge = firstAge;
    }

    @Basic
    @Column(name = "first_sex")
    public String getFirstSex() {
        return firstSex;
    }

    public void setFirstSex(String firstSex) {
        this.firstSex = firstSex;
    }

    @Basic
    @Column(name = "registNum")
    public Short getRegistNum() {
        return registNum;
    }

    public void setRegistNum(Short registNum) {
        this.registNum = registNum;
    }

    @Basic
    @Column(name = "playNum")
    public Short getPlayNum() {
        return playNum;
    }

    public void setPlayNum(Short playNum) {
        this.playNum = playNum;
    }

    @Basic
    @Column(name = "scoreNum")
    public Short getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(Short scoreNum) {
        this.scoreNum = scoreNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FirstmatchEntity that = (FirstmatchEntity) o;
        return Objects.equals(firstId, that.firstId) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(firstAge, that.firstAge) &&
                Objects.equals(firstSex, that.firstSex) &&
                Objects.equals(registNum, that.registNum) &&
                Objects.equals(playNum, that.playNum) &&
                Objects.equals(scoreNum, that.scoreNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstId, firstName, firstAge, firstSex, registNum, playNum, scoreNum);
    }
}
