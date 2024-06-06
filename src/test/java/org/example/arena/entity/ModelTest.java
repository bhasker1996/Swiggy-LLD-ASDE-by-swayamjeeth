package org.example.arena.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModelTest {
    private Player player;
    private Dice dice;
    private int health;

    @BeforeEach
    public void setUp() {
        health = 100;
        player = new Player.Builder().setHealth(health).build();
        dice = new Dice();
    }

    @Test
    public void testPlayerDamage() {
        player.takeDamage(50);
        assertEquals(Math.max(health - 50, 0), player.getHealth());
        player.takeDamage(Integer.MAX_VALUE);
        assertTrue(player.isDead());
    }


    @Test
    public void testDice() {
        for (int i = 0; i < 50; i++) {
            int roll = dice.roll();
            assertTrue(roll >= 1 && roll <= 6);
        }
    }

}
