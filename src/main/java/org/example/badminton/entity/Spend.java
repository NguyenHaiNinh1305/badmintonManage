package org.example.badminton.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "spend")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Spend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "team_season_id")
    private TeamSeason teamSeason;
    private LocalDate spentDate;
    private Long spend;

    @Enumerated(EnumType.STRING)
    private SpendType type; // slot, shuttlecock, other

    // Getters, setters, constructors, etc.
}
