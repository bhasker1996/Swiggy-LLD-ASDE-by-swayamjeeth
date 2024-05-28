package org.example.arena.utils;

import org.example.arena.models.Player;
import org.example.arena.models.PlayerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PlayerRegistryTest {

    private PlayerPrototypeRegistry registry;

    @BeforeEach
    public void setUp() {
        registry = new PlayerPrototypeRegistry();
    }

    @Test
    public void testPrototypeLoading() {
        for(PlayerType type : PlayerType.values()) {
            Player player = registry.getPrototype(type);
            assertNotNull(player);
            assertInstanceOf(Integer.class, player.getHealth());
            assertInstanceOf(Integer.class, player.getAttackPower());
            assertInstanceOf(Integer.class, player.getDefenseStrength());
            assertEquals(type, player.getType());
            assertNull(player.getName());
            assertEquals(0, player.getId());
        }
    }
}
