package org.example.badminton.repository;

import org.example.badminton.entity.Spend;
import org.example.badminton.entity.TeamSeason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpendRepository extends JpaRepository<Spend, Integer> {
    List<Spend> findByTeamSeasonId(Integer integer);
    List<Spend> findAllByTeamSeasonIn(List<TeamSeason> spendids);

}
