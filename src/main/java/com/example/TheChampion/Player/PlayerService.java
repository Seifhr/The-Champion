package com.example.TheChampion.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    private static final int MaximumSize=12;

    public Player registerPlayer(String name, String email) {
        if (getAllPlayers().size()<MaximumSize) {
            Player player = new Player(name, email);
            return playerRepository.save(player);
        }
        throw new IllegalStateException("maximum number of players");
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}
