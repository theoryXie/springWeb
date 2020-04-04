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
@Table(name = "coach", schema = "gym_sys", catalog = "")
public class CoachEntity {
    private short coachId;
    private String coachName;
    private String coachIdcard;
    private String coachPhone;
    private String coachSex;

    @Id
    @GeneratedValue
    @Column(name = "coach_id")
    public short getCoachId() {
        return coachId;
    }

    public void setCoachId(short coachId) {
        this.coachId = coachId;
    }

    @Basic
    @Column(name = "coach_name")
    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    @Basic
    @Column(name = "coach_idcard")
    public String getCoachIdcard() {
        return coachIdcard;
    }

    public void setCoachIdcard(String coachIdcard) {
        this.coachIdcard = coachIdcard;
    }

    @Basic
    @Column(name = "coach_phone")
    public String getCoachPhone() {
        return coachPhone;
    }

    public void setCoachPhone(String coachPhone) {
        this.coachPhone = coachPhone;
    }

    @Basic
    @Column(name = "coach_sex")
    public String getCoachSex() {
        return coachSex;
    }

    public void setCoachSex(String coachSex) {
        this.coachSex = coachSex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoachEntity that = (CoachEntity) o;
        return coachId == that.coachId &&
                Objects.equals(coachName, that.coachName) &&
                Objects.equals(coachIdcard, that.coachIdcard) &&
                Objects.equals(coachPhone, that.coachPhone) &&
                Objects.equals(coachSex, that.coachSex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coachId, coachName, coachIdcard, coachPhone, coachSex);
    }
}
