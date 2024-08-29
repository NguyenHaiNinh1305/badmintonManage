package org.example.badminton.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "income")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "team_season_id")
    private TeamSeason teamSeason;
    private Long income;

    @Enumerated(EnumType.STRING)
    private IncomeType type; // fixed, flex, other

    // Getters, setters, constructors, etc.
}
