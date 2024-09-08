package com.example.TheChampion.League;

import com.example.TheChampion.EmailService;
import com.example.TheChampion.Match.Match;
import com.example.TheChampion.Match.MatchService;
import com.example.TheChampion.Player.Player;
import com.example.TheChampion.Player.PlayerController;
import com.example.TheChampion.Player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class LeagueService {
    @Autowired
    private MatchService matchService;

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private EmailService emailService;


    public League createLeague() {
        List<Match> matches = matchService.createMatch();
        League league = new League(matches);
        return leagueRepository.save(league);
    }

    public void closeLeague(Long leagueId,Long winnerId) {
        League league = leagueRepository.findById(leagueId).orElseThrow();
        league.setFinished(true);
        league.setWinnerID(winnerId);
        leagueRepository.save(league);
    }
}
