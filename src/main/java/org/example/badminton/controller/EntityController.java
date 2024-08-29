package org.example.badminton.controller;

import lombok.RequiredArgsConstructor;
import org.example.badminton.entity.*;
import org.example.badminton.service.EntityService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EntityController {

    private final EntityService entityService;

    // Team endpoints
    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return entityService.getAllTeams();
    }

    @GetMapping("/teams/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Integer id) {
        Optional<Team> team = entityService.getTeamById(id);
        return team.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/teams")
    public Team saveTeam(@RequestBody Team team) {
        return entityService.saveTeam(team);
    }

    @PutMapping("/teams")
    public Team updateTeam(@RequestBody Team team) {
        return entityService.updateTeam(team);
    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<Void> deleteTeamById(@PathVariable Integer id) {
        entityService.deleteTeamById(id);
        return ResponseEntity.noContent().build();
    }

    // Member endpoints
    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return entityService.getAllMembers();
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Integer id) {
        Optional<Member> member = entityService.getMemberById(id);
        return member.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/members")
    public Member saveMember(@RequestBody Member member) {
        return entityService.saveMember(member);
    }

    @PutMapping("/members")
    public Member updateMember(@RequestBody Member member) {
        return entityService.updateMember(member);
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<Void> deleteMemberById(@PathVariable Integer id) {
        entityService.deleteMemberById(id);
        return ResponseEntity.noContent().build();
    }

    // TeamMember endpoints
    @GetMapping("/team-members")
    public List<TeamMember> getAllTeamMembers() {
        return entityService.getAllTeamMembers();
    }

    @GetMapping("/team-members/{id}")
    public ResponseEntity<TeamMember> getTeamMemberById(@PathVariable Integer id) {
        Optional<TeamMember> teamMember = entityService.getTeamMemberById(id);
        return teamMember.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/team-members")
    public TeamMember saveTeamMember(@Param("teamId") Integer teamId, @Param("memId") Integer memId) {
        return entityService.saveTeamMember(teamId, memId);
    }

    @PutMapping("/team-members")
    public TeamMember updateTeamMember(@RequestBody TeamMember teamMember) {
        return entityService.updateTeamMember(teamMember);
    }

    @DeleteMapping("/team-members/{id}")
    public ResponseEntity<Void> deleteTeamMemberById(@PathVariable Integer id) {
        entityService.deleteTeamMemberById(id);
        return ResponseEntity.noContent().build();
    }

    // Spend endpoints
    @GetMapping("/spends")
    public List<Spend> getAllSpends() {
        return entityService.getAllSpends();
    }

    @GetMapping("/spends/{id}")
    public ResponseEntity<Spend> getSpendById(@PathVariable Integer id) {
        Optional<Spend> spend = entityService.getSpendById(id);
        return spend.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/spends")
    public Spend saveSpend(@Param("teamSeasonId") Integer teamSeasonId,
                           @Param("type") SpendType type, @Param("spend") Long spend) {
        return entityService.saveSpend(teamSeasonId, type, spend);
    }

    @PutMapping("/spends")
    public Spend updateSpend(@RequestBody Spend spend) {
        return entityService.updateSpend(spend);
    }

    @DeleteMapping("/spends/{id}")
    public ResponseEntity<Void> deleteSpendById(@PathVariable Integer id) {
        entityService.deleteSpendById(id);
        return ResponseEntity.noContent().build();
    }

    // Season endpoints
    @GetMapping("/seasons")
    public List<Season> getAllSeasons() {
        return entityService.getAllSeasons();
    }

    @GetMapping("/seasons/{id}")
    public ResponseEntity<Season> getSeasonById(@PathVariable Integer id) {
        Optional<Season> season = entityService.getSeasonById(id);
        return season.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/seasons")
    public Season saveSeason(@RequestBody Season season) {
        return entityService.saveSeason(season);
    }

    @PutMapping("/seasons")
    public Season updateSeason(@RequestBody Season season) {
        return entityService.updateSeason(season);
    }

    @DeleteMapping("/seasons/{id}")
    public ResponseEntity<Void> deleteSeasonById(@PathVariable Integer id) {
        entityService.deleteSeasonById(id);
        return ResponseEntity.noContent().build();
    }

    // Income endpoints
    @GetMapping("/incomes")
    public List<Income> getAllIncomes() {
        return entityService.getAllIncomes();
    }

    @GetMapping("/incomes/{id}")
    public ResponseEntity<Income> getIncomeById(@PathVariable Integer id) {
        Optional<Income> income = entityService.getIncomeById(id);
        return income.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/incomes")
    public Income saveIncome(@Param("teamSeasonId") Integer teamSeasonId,
                             @Param("type") IncomeType type, @Param("income") Long income) {
        return entityService.saveIncome(teamSeasonId, type, income);
    }

    @PutMapping("/incomes")
    public Income updateIncome(@RequestBody Income income) {
        return entityService.updateIncome(income);
    }

    @DeleteMapping("/incomes/{id}")
    public ResponseEntity<Void> deleteIncomeById(@PathVariable Integer id) {
        entityService.deleteIncomeById(id);
        return ResponseEntity.noContent().build();
    }

    // TeamSeason endpoints
    @GetMapping("/team-seasons")
    public List<TeamSeason> getAllTeamSeasons() {
        return entityService.getAllTeamSeasons();
    }

    @GetMapping("/team-seasons/{id}")
    public ResponseEntity<TeamSeason> getTeamSeasonById(@PathVariable Integer id) {
        Optional<TeamSeason> teamSeason = entityService.getTeamSeasonById(id);
        return teamSeason.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/team-seasons")
    public TeamSeason saveTeamSeason(@Param("teamMemid") Integer teamMemId, @Param("seasonId") Integer seasonId) {
        return entityService.saveTeamSeason(teamMemId, seasonId);
    }

    @PutMapping("/team-seasons")
    public TeamSeason updateTeamSeason(@RequestBody TeamSeason teamSeason) {
        return entityService.updateTeamSeason(teamSeason);
    }

    @DeleteMapping("/team-seasons/{id}")
    public ResponseEntity<Void> deleteTeamSeasonById(@PathVariable Integer id) {
        entityService.deleteTeamSeasonById(id);
        return ResponseEntity.noContent().build();
    }
}