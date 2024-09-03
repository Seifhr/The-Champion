package com.example.TheChampion.Match;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
@Tag(name = "Match Controller", description = "Manage matches")
public class MatchController {
    @Autowired
    private MatchService matchService;

    @Operation(summary = "Create match")
    @PostMapping("/createMathces")
    public List<Match> createMatch() {
        return matchService.createMatch();
    }

    @Operation(summary = "Update match")
    @PostMapping("/{matchId}/result")
    public void updateMatchResult(@PathVariable Long matchId, @RequestParam Long winnerId) {
        matchService.updateMatchResult(matchId, winnerId);
    }

    @Operation(summary = "Get all matches")
    @GetMapping
    public List<Match> getAllMatches() {
        return matchService.getMatches();
    }
}
