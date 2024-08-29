package org.example.badminton.repository;

import org.example.badminton.entity.TeamSeason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamSeasonRepository extends JpaRepository<TeamSeason, Integer> {
    List<TeamSeason> findBySeasonId(Integer seasonId);
}
