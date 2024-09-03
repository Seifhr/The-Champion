package com.example.TheChampion.League;

import com.example.TheChampion.Match.Match;
import com.example.TheChampion.Match.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueService {
    @Autowired
    private MatchService matchService;

    @Autowired
    private LeagueRepository leagueRepository;

    public League createLeague() {
        List<Match> matches = matchService.createMatch();
        League league = new League(matches);
        return leagueRepository.save(league);
    }

    public void closeLeague(Long leagueId) {
        League league = leagueRepository.findById(leagueId).orElseThrow();
        league.setFinished(true);
        leagueRepository.save(league);
    }
}
