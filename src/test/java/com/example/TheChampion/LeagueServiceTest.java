package com.example.TheChampion;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.TheChampion.League.League;
import com.example.TheChampion.League.LeagueRepository;
import com.example.TheChampion.Match.Match;
import com.example.TheChampion.Match.MatchRepository;
import com.example.TheChampion.League.LeagueService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class LeagueServiceTest {

    @Mock
    private MatchRepository matchRepository;

    @Mock
    private LeagueRepository leagueRepository;

    @InjectMocks
    private LeagueService leagueService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateLeague() {
        Match match1 = new Match();
        Match match2 = new Match();
        List<Match> matches = Arrays.asList(match1, match2);

        when(matchRepository.findAll()).thenReturn(matches);

        League league = new League(matches);
        when(leagueRepository.save(any(League.class))).thenReturn(league);

        League result = leagueService.createLeague();

        assertNotNull(result);
        assertEquals(2, result.getMatches().size());
        verify(matchRepository).findAll();
        verify(leagueRepository).save(any(League.class));
    }
}