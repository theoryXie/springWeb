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
@Table(name = "referee", schema = "gym_sys", catalog = "")
public class RefereeEntity {
    private short refereeId;
    private String refereeName;
    private String refereeIdcard;
    private String refereePhone;

    @Id
    @GeneratedValue
    @Column(name = "referee_id")
    public short getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(short refereeId) {
        this.refereeId = refereeId;
    }

    @Basic
    @Column(name = "referee_name")
    public String getRefereeName() {
        return refereeName;
    }

    public void setRefereeName(String refereeName) {
        this.refereeName = refereeName;
    }

    @Basic
    @Column(name = "referee_idcard")
    public String getRefereeIdcard() {
        return refereeIdcard;
    }

    public void setRefereeIdcard(String refereeIdcard) {
        this.refereeIdcard = refereeIdcard;
    }

    @Basic
    @Column(name = "referee_phone")
    public String getRefereePhone() {
        return refereePhone;
    }

    public void setRefereePhone(String refereePhone) {
        this.refereePhone = refereePhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RefereeEntity that = (RefereeEntity) o;
        return refereeId == that.refereeId &&
                Objects.equals(refereeName, that.refereeName) &&
                Objects.equals(refereeIdcard, that.refereeIdcard) &&
                Objects.equals(refereePhone, that.refereePhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refereeId, refereeName, refereeIdcard, refereePhone);
    }
}
