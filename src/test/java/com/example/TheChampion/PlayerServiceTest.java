package com.example.TheChampion;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.TheChampion.Player.Player;
import com.example.TheChampion.Player.PlayerRepository;
import com.example.TheChampion.Player.PlayerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePlayer() {
        Player player = new Player("seif","seif@seif.com");

        when(playerRepository.save(any(Player.class))).thenReturn(player);

        Player result = playerService.registerPlayer(player.getName(),player.getEmail());

        assertNotNull(result);
        assertEquals("seif", result.getName());
        verify(playerRepository).findAll();
    }
}