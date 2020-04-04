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
@Table(name = "doctor", schema = "gym_sys", catalog = "")
public class DoctorEntity {
    private short doctorId;
    private String doctorName;
    private String doctorIdcard;
    private String doctorPhone;

    @Id
    @GeneratedValue
    @Column(name = "doctor_id")
    public short getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(short doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "doctor_name")
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @Basic
    @Column(name = "doctor_idcard")
    public String getDoctorIdcard() {
        return doctorIdcard;
    }

    public void setDoctorIdcard(String doctorIdcard) {
        this.doctorIdcard = doctorIdcard;
    }

    @Basic
    @Column(name = "doctor_phone")
    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorEntity that = (DoctorEntity) o;
        return doctorId == that.doctorId &&
                Objects.equals(doctorName, that.doctorName) &&
                Objects.equals(doctorIdcard, that.doctorIdcard) &&
                Objects.equals(doctorPhone, that.doctorPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId, doctorName, doctorIdcard, doctorPhone);
    }
}
