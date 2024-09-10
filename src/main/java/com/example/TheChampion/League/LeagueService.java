package com.example.TheChampion.League;

import com.example.TheChampion.Match.Match;
import com.example.TheChampion.Match.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueService {
    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private LeagueRepository leagueRepository;

    public League createLeague() {
        List<Match> matches = matchRepository.findAll();
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
