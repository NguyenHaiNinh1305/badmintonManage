package org.example.badminton.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "team_season")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TeamSeason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "team_mem_id")
    private TeamMember teamMember;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    private Long realContrib;
    private Long needContrib;

    // Getters, setters, constructors, etc.
}
