package com.example.TheChampion.League;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/league")
@Tag(name = "League Controller", description = "Manage league")
public class LeagueController {
    @Autowired
    private LeagueService leagueService;

    @Operation(summary = "Create league")
    @PostMapping
    public League createLeague() {
        return leagueService.createLeague();
    }

    @Operation(summary = "Close league")
    @PostMapping("/{leagueId}/close")
    public void closeLeague(@PathVariable Long leagueId) {
        leagueService.closeLeague(leagueId);
    }
}
