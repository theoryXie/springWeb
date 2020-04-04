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
@Table(name = "final_referee", schema = "gym_sys", catalog = "")
public class FinalRefereeEntity {
    private short id;
    private Short refereeId;
    private String finalMatchId;
    private Short refereeGroup;
    private String isMain;

    @Id
    @Column(name = "id")
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "refereeId")
    public Short getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(Short refereeId) {
        this.refereeId = refereeId;
    }

    @Basic
    @Column(name = "finalMatchId")
    public String getFinalMatchId() {
        return finalMatchId;
    }

    public void setFinalMatchId(String finalMatchId) {
        this.finalMatchId = finalMatchId;
    }

    @Basic
    @Column(name = "referee_group")
    public Short getRefereeGroup() {
        return refereeGroup;
    }

    public void setRefereeGroup(Short refereeGroup) {
        this.refereeGroup = refereeGroup;
    }

    @Basic
    @Column(name = "isMain")
    public String getIsMain() {
        return isMain;
    }

    public void setIsMain(String isMain) {
        this.isMain = isMain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinalRefereeEntity that = (FinalRefereeEntity) o;
        return id == that.id &&
                Objects.equals(refereeId, that.refereeId) &&
                Objects.equals(finalMatchId, that.finalMatchId) &&
                Objects.equals(refereeGroup, that.refereeGroup) &&
                Objects.equals(isMain, that.isMain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, refereeId, finalMatchId, refereeGroup, isMain);
    }
}
