package org.example.badminton.service;

import lombok.RequiredArgsConstructor;
import org.example.badminton.entity.*;
import org.example.badminton.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ProService {
    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;
    private final TeamMemberRepository teamMemberRepository;
    private final SpendRepository spendRepository;
    private final SeasonRepository seasonRepository;
    private final IncomeRepository incomeRepository;
    private final TeamSeasonRepository teamSeasonRepository;


//    public List<TeamSeason> calcNeedContrib(Integer seasonId) {
//        List<TeamSeason> teamSeasons = teamSeasonRepository.findBySeasonId(seasonId);
//        // Early exit if no team seasons are found
//        if (teamSeasons.isEmpty()) {
//            return Collections.emptyList();
//        }
//        List<TeamSeason> teamSeasonsSave = new ArrayList<>();
//        Long fee = teamSeasons.get(0).getSeason().getFee();
//        float needContrPerMem = (float) fee / teamSeasons.size();
//        for (TeamSeason teamSeason : teamSeasons) {
//            List<Spend> spend = spendRepository.findByTeamSeasonId(teamSeason.getId());
//            long totalSpend = spend.stream().mapToLong(Spend::getSpend).sum();
//            teamSeason.setNeedContrib((long) (needContrPerMem - totalSpend - teamSeason.getRealContrib()));
//            teamSeasonsSave.add(teamSeason);
//        }
//       return  teamSeasonRepository.saveAll(teamSeasonsSave);
//    }
    public List<TeamSeason> calcNeedContrib(Integer seasonId) {
        List<TeamSeason> teamSeasons = teamSeasonRepository.findBySeasonId(seasonId);

        // Early exit if no team seasons are found
        if (teamSeasons.isEmpty()) {
            return Collections.emptyList();
        }

        Long fee = teamSeasons.get(0).getSeason().getFee();
        float needContrPerMem = (float) fee / teamSeasons.size();

        List<Spend> allSpends = spendRepository.findAllByTeamSeasonIn(teamSeasons);

        // Create a map to store total spend per team season
        Map<Integer, Long> totalSpendMap = allSpends.stream()
                .collect(Collectors.groupingBy(spend -> spend.getTeamSeason().getId(),
                        Collectors.summingLong(Spend::getSpend)));

        // Calculate the need contribution for each team season
        for (TeamSeason teamSeason : teamSeasons) {
            long totalSpend = totalSpendMap.getOrDefault(teamSeason.getId(), 0L);
            teamSeason.setNeedContrib((long) (needContrPerMem - totalSpend - (teamSeason.getRealContrib()!= null? teamSeason.getRealContrib():0)));
        }

        return teamSeasonRepository.saveAll(teamSeasons);
    }
}
