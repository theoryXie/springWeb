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
@Table(name = "final_play", schema = "gym_sys", catalog = "")
public class FinalPlayEntity {
    private short id;
    private String playId;
    private String finalId;
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
    @Column(name = "final_id")
    public String getFinalId() {
        return finalId;
    }

    public void setFinalId(String finalId) {
        this.finalId = finalId;
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
        FinalPlayEntity that = (FinalPlayEntity) o;
        return id == that.id &&
                Objects.equals(playId, that.playId) &&
                Objects.equals(finalId, that.finalId) &&
                Objects.equals(playGroup, that.playGroup) &&
                Objects.equals(playScore, that.playScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playId, finalId, playGroup, playScore);
    }
}
