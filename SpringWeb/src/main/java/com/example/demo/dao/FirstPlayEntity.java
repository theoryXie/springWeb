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
@Table(name = "first_play", schema = "gym_sys", catalog = "")
public class FirstPlayEntity {
    private short id;
    private String playId;
    private String firstId;
    private Short playGroup;
    private Short playScore;

    @Id
    @Column(name = "id")
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "play_id")
    public String getPlayId() {
        return playId;
    }

    public void setPlayId(String playId) {
        this.playId = playId;
    }

    @Basic
    @Column(name = "first_id")
    public String getFirstId() {
        return firstId;
    }

    public void setFirstId(String firstId) {
        this.firstId = firstId;
    }

    @Basic
    @Column(name = "play_group")
    public Short getPlayGroup() {
        return playGroup;
    }

    public void setPlayGroup(Short playGroup) {
        this.playGroup = playGroup;
    }

    @Basic
    @Column(name = "play_score")
    public Short getPlayScore() {
        return playScore;
    }

    public void setPlayScore(Short playScore) {
        this.playScore = playScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FirstPlayEntity that = (FirstPlayEntity) o;
        return id == that.id &&
                Objects.equals(playId, that.playId) &&
                Objects.equals(firstId, that.firstId) &&
                Objects.equals(playGroup, that.playGroup) &&
                Objects.equals(playScore, that.playScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playId, firstId, playGroup, playScore);
    }
}
