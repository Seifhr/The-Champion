package com.example.TheChampion.League;

import com.example.TheChampion.EmailService;
import com.example.TheChampion.Player.Player;
import com.example.TheChampion.Player.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;

@RestController
@RequestMapping("/league")
@Tag(name = "League Controller", description = "Manage league")
public class LeagueController {
    @Autowired
    private LeagueService leagueService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private EmailService emailService;


    @Operation(summary = "Create league")
    @PostMapping
    public League createLeague() {
        return leagueService.createLeague();
    }

    @Operation(summary = "Close league")
    @PostMapping("/{leagueId}/close")
    public void closeLeague(@PathVariable Long leagueId) {
        leagueService.closeLeague(leagueId);
        Player winner = playerService.getAllPlayers().stream().max(Comparator.comparingInt(Player::getPoints)).orElseThrow(() -> new RuntimeException("No players found"));
        String email = winner.getEmail();
        sendEmail(email,"Congratulations!!","Congratulations on winning the league");
    }
    public String sendEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String text) {
        emailService.sendSimpleEmail(to, subject, text);
        return "Email sent successfully!";
    }
}
