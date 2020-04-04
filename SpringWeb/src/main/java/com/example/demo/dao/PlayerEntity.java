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
@Table(name = "player", schema = "gym_sys", catalog = "")
public class PlayerEntity {
    private String playerId;
    private String playerName;
    private String playerIdcard;
    private short playerAge;
    private short playerTeam;
    private String playerMatch;
    private Short playerScore;
    private String playerSex;

    @Id
    @Column(name = "player_id")
    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    @Basic
    @Column(name = "player_name")
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Basic
    @Column(name = "player_idcard")
    public String getPlayerIdcard() {
        return playerIdcard;
    }

    public void setPlayerIdcard(String playerIdcard) {
        this.playerIdcard = playerIdcard;
    }

    @Basic
    @Column(name = "player_age")
    public short getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(short playerAge) {
        this.playerAge = playerAge;
    }

    @Basic
    @Column(name = "player_team")
    public short getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(short playerTeam) {
        this.playerTeam = playerTeam;
    }

    @Basic
    @Column(name = "player_match")
    public String getPlayerMatch() {
        return playerMatch;
    }

    public void setPlayerMatch(String playerMatch) {
        this.playerMatch = playerMatch;
    }

    @Basic
    @Column(name = "player_score")
    public Short getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(Short playerScore) {
        this.playerScore = playerScore;
    }

    @Basic
    @Column(name = "player_sex")
    public String getPlayerSex() {
        return playerSex;
    }

    public void setPlayerSex(String playerSex) {
        this.playerSex = playerSex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerEntity that = (PlayerEntity) o;
        return playerAge == that.playerAge &&
                playerTeam == that.playerTeam &&
                Objects.equals(playerId, that.playerId) &&
                Objects.equals(playerName, that.playerName) &&
                Objects.equals(playerIdcard, that.playerIdcard) &&
                Objects.equals(playerMatch, that.playerMatch) &&
                Objects.equals(playerScore, that.playerScore) &&
                Objects.equals(playerSex, that.playerSex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, playerName, playerIdcard, playerAge, playerTeam, playerMatch, playerScore, playerSex);
    }
}
