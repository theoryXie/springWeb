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
@Table(name = "leader", schema = "gym_sys", catalog = "")
public class LeaderEntity {
    private short leaderId;
    private String leaderName;
    private String leaderIdcard;
    private String leaderPhone;

    @Id
    @GeneratedValue
    @Column(name = "leader_id")
    public short getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(short leaderId) {
        this.leaderId = leaderId;
    }

    @Basic
    @Column(name = "leader_name")
    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    @Basic
    @Column(name = "leader_idcard")
    public String getLeaderIdcard() {
        return leaderIdcard;
    }

    public void setLeaderIdcard(String leaderIdcard) {
        this.leaderIdcard = leaderIdcard;
    }

    @Basic
    @Column(name = "leader_phone")
    public String getLeaderPhone() {
        return leaderPhone;
    }

    public void setLeaderPhone(String leaderPhone) {
        this.leaderPhone = leaderPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeaderEntity that = (LeaderEntity) o;
        return leaderId == that.leaderId &&
                Objects.equals(leaderName, that.leaderName) &&
                Objects.equals(leaderIdcard, that.leaderIdcard) &&
                Objects.equals(leaderPhone, that.leaderPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leaderId, leaderName, leaderIdcard, leaderPhone);
    }
}
