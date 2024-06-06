package org.example.arena;

import org.example.arena.exceptions.GameNotOverException;
import org.example.arena.entity.Player;
import org.example.arena.entity.TurnResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameServiceTest {
    private Player player1;
    private Player player2;
    private GameService gameService;

    @BeforeEach
    public void setUp() {
        player1 = new Player.Builder().setHealth(100).setAttackPower(100).setDefenseStrength(100).build();
        player2 = new Player.Builder().setHealth(10).setAttackPower(10).setDefenseStrength(10).build();
        gameService = new GameService();
    }

    @Test
    public void testPlayTurn() {
        TurnResult result = gameService.playTurn(player1, player2);

        assertInstanceOf(TurnResult.class, result);

        int maxAttackDamage = player1.getAttackPower() * 6;
        int minAttackDamage = player1.getAttackPower();
        int maxDefensePower = player2.getDefenseStrength() * 6;
        int minDefensePower = player2.getDefenseStrength();

        assertTrue(result.attackDamage() >= minAttackDamage && result.attackDamage() <= maxAttackDamage);
        assertTrue(result.defensePower() >= minDefensePower && result.defensePower() <= maxDefensePower);
        assertEquals(result.damage(), Math.max(0, result.attackDamage() - result.defensePower()));

        int expectedHealth = player2.getHealth() - result.damage();
        expectedHealth = Math.max(expectedHealth, 0);
        assertEquals(expectedHealth, player2.getHealth());
    }

    @Test
    public void testIsGameOver() {
        player2.takeDamage(10);
        assertTrue(gameService.isGameOver(player1, player2));
        assertFalse(gameService.isGameOver(player1, player1));
    }

    @Test
    public void testGetWinner() throws GameNotOverException {
        player2.takeDamage(10);
        Player winner = gameService.getWinner(player1, player2);
        assertEquals(player1, winner);

        Exception exception = assertThrows(GameNotOverException.class, () -> gameService.getWinner(player1, player1));
        assertEquals("Cannot determine winner for game while it is ongoing.", exception.getMessage());
    }
}
