package com.example.TheChampion;

import com.example.TheChampion.Match.*;
import com.example.TheChampion.Player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class MatchServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private MatchRepository matchRepository;

    @InjectMocks
    private MatchService matchService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatematch() {
        // Arrange
        Player player1 = new Player("Seif", "Seif@seif.com");
        Player player2 = new Player("ramy", "ramy@ramy.com");
        Player player3 = new Player("alpha", "alpha@alpha.com");
        Player player4 = new Player("beta", "beta@beta.com");

        List<Player> players = Arrays.asList(player1, player2, player3, player4);

        when(playerRepository.findAll()).thenReturn(players);

        // Act
        matchService.createMatch();

        // Assert
        verify(matchRepository, times(6)).save(any(Match.class));
    }
}