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
@Table(name = "finalmatch", schema = "gym_sys", catalog = "")
public class FinalmatchEntity {
    private String finalId;
    private String finalName;
    private String finalAge;
    private String finalSex;
    private Short registNum;
    private Short playNum;
    private Short scoreNum;

    @Id
    @Column(name = "final_id")
    public String getFinalId() {
        return finalId;
    }

    public void setFinalId(String finalId) {
        this.finalId = finalId;
    }

    @Basic
    @Column(name = "final_name")
    public String getFinalName() {
        return finalName;
    }

    public void setFinalName(String finalName) {
        this.finalName = finalName;
    }

    @Basic
    @Column(name = "final_age")
    public String getFinalAge() {
        return finalAge;
    }

    public void setFinalAge(String finalAge) {
        this.finalAge = finalAge;
    }

    @Basic
    @Column(name = "final_sex")
    public String getFinalSex() {
        return finalSex;
    }

    public void setFinalSex(String finalSex) {
        this.finalSex = finalSex;
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
        FinalmatchEntity that = (FinalmatchEntity) o;
        return Objects.equals(finalId, that.finalId) &&
                Objects.equals(finalName, that.finalName) &&
                Objects.equals(finalAge, that.finalAge) &&
                Objects.equals(finalSex, that.finalSex) &&
                Objects.equals(registNum, that.registNum) &&
                Objects.equals(playNum, that.playNum) &&
                Objects.equals(scoreNum, that.scoreNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(finalId, finalName, finalAge, finalSex, registNum, playNum, scoreNum);
    }
}
