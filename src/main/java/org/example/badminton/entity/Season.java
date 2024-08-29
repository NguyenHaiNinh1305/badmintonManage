package org.example.badminton.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "season")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long fee;
    private Long totalIncome;
    private LocalDate startDate;
    private LocalDate endDate;

    // Getters, setters, constructors, etc.
}
