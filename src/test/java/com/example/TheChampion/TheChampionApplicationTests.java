package com.example.TheChampion;

import com.example.TheChampion.Player.Player;
import com.example.TheChampion.Player.PlayerRepository;
import com.example.TheChampion.Player.PlayerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class TheChampionApplicationTests {

	@Autowired
	private PlayerService playerService;

	@MockBean
	private PlayerRepository playerRepository;

	@Test
	public void testRegisterPlayer() {
		Player player = new Player("John Doe", "john.doe@example.com");
		when(playerRepository.save(Mockito.any(Player.class))).thenReturn(player);

		Player savedPlayer = playerService.registerPlayer("John Doe", "john.doe@example.com");
		assertEquals("John Doe", savedPlayer.getName());
	}
}
