package com.example.TheChampion.Match;

import com.example.TheChampion.Player.Player;
import com.example.TheChampion.Player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public List<Match> createMatch() {
        List<Player> players = playerRepository.findAll();
        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                Player player1 = players.get(i);
                Player player2 = players.get(j);

                Match match = new Match();
                match.setPlayer1(player1);
                match.setPlayer2(player2);

                matchRepository.save(match);
            }
        }
        return  matchRepository.findAll();
    }

    public void updateMatchResult(Long matchId, Long winnerId) {
        Match match = matchRepository.findById(matchId).orElseThrow();
        match.setWinnerId(winnerId);
        match.setClosed(true);
        Player player = playerRepository.findById(winnerId).orElseThrow();
        player.setPoints(player.getPoints()+1);
        matchRepository.save(match);
        playerRepository.save(player);
    }

    public List<Match> getMatches() {
        return matchRepository.findAll();
    }
}
