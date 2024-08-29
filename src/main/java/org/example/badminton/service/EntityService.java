package org.example.badminton.service;

import lombok.RequiredArgsConstructor;
import org.example.badminton.entity.*;
import org.example.badminton.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EntityService {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;
    private final TeamMemberRepository teamMemberRepository;
    private final SpendRepository spendRepository;
    private final SeasonRepository seasonRepository;
    private final IncomeRepository incomeRepository;
    private final TeamSeasonRepository teamSeasonRepository;

    // Team CRUD operations
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Integer id) {
        return teamRepository.findById(id);
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeamById(Integer id) {
        teamRepository.deleteById(id);
    }

    public Team updateTeam(Team team) {
        return teamRepository.save(team);
    }

    // Member CRUD operations
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Integer id) {
        return memberRepository.findById(id);
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public void deleteMemberById(Integer id) {
        memberRepository.deleteById(id);
    }

    public Member updateMember(Member member) {
        return memberRepository.save(member);
    }

    // TeamMember CRUD operations
    public List<TeamMember> getAllTeamMembers() {
        return teamMemberRepository.findAll();
    }

    public Optional<TeamMember> getTeamMemberById(Integer id) {
        return teamMemberRepository.findById(id);
    }

    public TeamMember saveTeamMember(Integer teamId, Integer memid) {
        Team team = teamRepository.findById(teamId).orElse(null);
        Member member = memberRepository.findById(memid).orElse(null);
        if(team == null || member == null){
            throw new RuntimeException("lỗi");
        }
        TeamMember teamMember = new TeamMember();
        teamMember.setTeam(team);
        teamMember.setMember(member);
        return teamMemberRepository.save(teamMember);
    }

    public void deleteTeamMemberById(Integer id) {
        teamMemberRepository.deleteById(id);
    }

    public TeamMember updateTeamMember(TeamMember teamMember) {
        return teamMemberRepository.save(teamMember);
    }

    // Spend CRUD operations
    public List<Spend> getAllSpends() {
        return spendRepository.findAll();
    }

    public Optional<Spend> getSpendById(Integer id) {
        return spendRepository.findById(id);
    }

    public Spend saveSpend( Integer teamSeasonId,
                            SpendType type, Long spend) {
        TeamSeason teamSeason = teamSeasonRepository.findById(teamSeasonId).orElse(null);
        if(teamSeason == null){
            throw new RuntimeException("lỗi");
        }
        Spend spend1 = Spend.builder().teamSeason(teamSeason).type(type).spend(spend).build();
        return spendRepository.save(spend1);
    }

    public void deleteSpendById(Integer id) {
        spendRepository.deleteById(id);
    }

    public Spend updateSpend(Spend spend) {
        return spendRepository.save(spend);
    }

    // Season CRUD operations
    public List<Season> getAllSeasons() {
        return seasonRepository.findAll();
    }

    public Optional<Season> getSeasonById(Integer id) {
        return seasonRepository.findById(id);
    }

    public Season saveSeason(Season season) {
        return seasonRepository.save(season);
    }

    public void deleteSeasonById(Integer id) {
        seasonRepository.deleteById(id);
    }

    public Season updateSeason(Season season) {
        return seasonRepository.save(season);
    }

    // Income CRUD operations
    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    public Optional<Income> getIncomeById(Integer id) {
        return incomeRepository.findById(id);
    }

    public Income saveIncome(Integer teamSeasonId,
                             IncomeType type, Long incomee) {
        TeamSeason teamSeason = teamSeasonRepository.findById(teamSeasonId).orElse(null);
        if(teamSeason == null){
            throw new RuntimeException("lỗi");
        }
        Income income = Income.builder().type(type).teamSeason(teamSeason).income(incomee).build();
        return incomeRepository.save(income);
    }

    public void deleteIncomeById(Integer id) {
        incomeRepository.deleteById(id);
    }

    public Income updateIncome(Income income) {
        return incomeRepository.save(income);
    }

    // TeamSeason CRUD operations
    public List<TeamSeason> getAllTeamSeasons() {
        return teamSeasonRepository.findAll();
    }

    public Optional<TeamSeason> getTeamSeasonById(Integer id) {
        return teamSeasonRepository.findById(id);
    }

    public TeamSeason saveTeamSeason(Integer teamMemId, Integer seasonId) {
        TeamMember  teamMember = teamMemberRepository.findById(teamMemId).orElse(null);
        Season season = seasonRepository.findById(seasonId).orElse(null);
        if(teamMember == null || season == null){
            throw new RuntimeException("lỗi");
        }
        TeamSeason teamSeason = TeamSeason.builder().teamMember(teamMember).season(season).build();
        return teamSeasonRepository.save(teamSeason);
    }

    public void deleteTeamSeasonById(Integer id) {
        teamSeasonRepository.deleteById(id);
    }

    public TeamSeason updateTeamSeason(TeamSeason teamSeason) {
        return teamSeasonRepository.save(teamSeason);
    }
}