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
@Table(name = "first_referee", schema = "gym_sys", catalog = "")
public class FirstRefereeEntity {
    private short id;
    private Short refereeid;
    private String firstMatchId;
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
    @Column(name = "refereeid")
    public Short getRefereeid() {
        return refereeid;
    }

    public void setRefereeid(Short refereeid) {
        this.refereeid = refereeid;
    }

    @Basic
    @Column(name = "firstMatchId")
    public String getFirstMatchId() {
        return firstMatchId;
    }

    public void setFirstMatchId(String firstMatchId) {
        this.firstMatchId = firstMatchId;
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
        FirstRefereeEntity that = (FirstRefereeEntity) o;
        return id == that.id &&
                Objects.equals(refereeid, that.refereeid) &&
                Objects.equals(firstMatchId, that.firstMatchId) &&
                Objects.equals(refereeGroup, that.refereeGroup) &&
                Objects.equals(isMain, that.isMain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, refereeid, firstMatchId, refereeGroup, isMain);
    }
}
