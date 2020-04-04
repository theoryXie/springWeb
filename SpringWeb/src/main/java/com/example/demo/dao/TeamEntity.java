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
@Table(name = "team", schema = "gym_sys", catalog = "")
public class TeamEntity {
    private short teamId;
    private String teamName;
    private short teamCoach;
    private short teamReferee;
    private short teamDoctor;
    private short teamLeader;
    private String teamAccount;
    private String teamPassword;

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    public short getTeamId() {
        return teamId;
    }

    public void setTeamId(short teamId) {
        this.teamId = teamId;
    }

    @Basic
    @Column(name = "team_name")
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Basic
    @Column(name = "team_coach")
    public short getTeamCoach() {
        return teamCoach;
    }

    public void setTeamCoach(short teamCoach) {
        this.teamCoach = teamCoach;
    }

    @Basic
    @Column(name = "team_referee")
    public short getTeamReferee() {
        return teamReferee;
    }

    public void setTeamReferee(short teamReferee) {
        this.teamReferee = teamReferee;
    }

    @Basic
    @Column(name = "team_doctor")
    public short getTeamDoctor() {
        return teamDoctor;
    }

    public void setTeamDoctor(short teamDoctor) {
        this.teamDoctor = teamDoctor;
    }

    @Basic
    @Column(name = "team_leader")
    public short getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(short teamLeader) {
        this.teamLeader = teamLeader;
    }

    @Basic
    @Column(name = "team_account")
    public String getTeamAccount() {
        return teamAccount;
    }

    public void setTeamAccount(String teamAccount) {
        this.teamAccount = teamAccount;
    }

    @Basic
    @Column(name = "team_password")
    public String getTeamPassword() {
        return teamPassword;
    }

    public void setTeamPassword(String teamPassword) {
        this.teamPassword = teamPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamEntity that = (TeamEntity) o;
        return teamId == that.teamId &&
                teamCoach == that.teamCoach &&
                teamReferee == that.teamReferee &&
                teamDoctor == that.teamDoctor &&
                teamLeader == that.teamLeader &&
                Objects.equals(teamName, that.teamName) &&
                Objects.equals(teamAccount, that.teamAccount) &&
                Objects.equals(teamPassword, that.teamPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, teamName, teamCoach, teamReferee, teamDoctor, teamLeader, teamAccount, teamPassword);
    }
}
