package com.example.TheChampion.Player;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@Tag(name = "Player Controller", description = "Manage players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @Operation(summary = "Create player")
    @PostMapping
    public Player registerPlayer(@Validated @RequestBody Player player) {
        return playerService.registerPlayer(player.getName(), player.getEmail());
    }

    @Operation(summary = "Get all players")
    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }
}
