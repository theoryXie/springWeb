package com.example.demo.repository;
import com.example.demo.dao.FirstPlayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface firstPlayRepository extends JpaRepository<FirstPlayEntity,String> {



    //查询姓名为xxx的比赛信息
    @Query(value = "SELECT first_name, first_age, first_sex, first_play.play_score FROM firstmatch natural join first_play " +
            "WHERE first_play.play_id = (SELECT player_id FROM player WHERE player_name = :player_name)",nativeQuery = true)
    List<Object> findMatchByPlayer(@Param("player_name") String playerName);

    //查询至少参加了x项比赛的运动员信息
    @Query(value = "SELECT distinct player_id,player_name, player_idcard, player_age,player_team,player_match,player_score,player_sex " +
            "FROM player, first_play WHERE player.player_id in (SELECT play_id from first_play group by play_id having count(first_id)>=:match_num)",nativeQuery = true)
    List<Object> findPlayerByMatchNum(@Param("match_num") int match_num);

    //查询比赛的排名
    @Query(value = "SELECT player_name,team_name, play_group,play_score\n" +
            "FROM player, first_play,team\n" +
            "WHERE player_id = play_id\n" +
            "AND player_team = team_id\n" +
            "AND first_id = (\n" +
            "\tSELECT first_id\n" +
            "    FROM firstmatch\n" +
            "    WHERE first_name=:match_name\n" +
            "    AND first_age = :match_age\n" +
            "    AND first_sex = :match_sex\n" +
            ")\n" +
            "group by play_score\n" +
            "order by play_score desc\n",nativeQuery = true)
    List<Object> getMatchInfoByType(@Param("match_name") String match_name,
                                    @Param("match_age") short match_age,
                                    @Param("match_sex") String match_sex);


    //报名
    @Query(value = "INSERT into first_play(play_id, first_id) values (?1,?2)",nativeQuery = true)
    boolean register(String play_id,
                  short first_id);
}
