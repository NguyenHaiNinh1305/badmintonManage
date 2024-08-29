package org.example.badminton.controller;

import lombok.RequiredArgsConstructor;
import org.example.badminton.entity.*;
import org.example.badminton.service.EntityService;
import org.example.badminton.service.ProService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pro")
@RequiredArgsConstructor
public class ProController {

    private final ProService proService;

    @PostMapping("/need/contrib")
    public List<TeamSeason> calcNeedContrib(@Param("seasonId") Integer seasonId) {
        return proService.calcNeedContrib(seasonId);
    }
}