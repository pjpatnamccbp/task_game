package com.game.restapis.repository;

import com.game.restapis.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score,Long> {
    List<Score> findByGameId(Long gameId);

    List<Score> findByGameIdAndUserName(Long gameId,String userName);

}
