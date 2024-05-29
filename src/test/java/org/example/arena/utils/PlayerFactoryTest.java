package org.example.arena.utils;

import org.example.arena.exceptions.InvalidClassSelection;
import org.example.arena.models.Player;
import org.example.arena.models.PlayerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerFactoryTest {
    private PlayerFactory factory;
    private PlayerType playerType;

    @BeforeEach
    public void setUp() {
        PlayerPrototypeRegistry registry = new PlayerPrototypeRegistry();
        factory = new PlayerFactory(registry);
        playerType = PlayerType.values()[0];
    }

    @Test
    public void testCreatePlayer() {
        Player player = factory.createPlayer("PlayerA", 1, 1);
        assertNotNull(player);
        assertEquals("PlayerA", player.getName());
        assertEquals(1, player.getId());
        assertEquals(playerType, player.getType());
        assertInstanceOf(Integer.class, player.getHealth());
        assertInstanceOf(Integer.class, player.getAttackPower());
        assertInstanceOf(Integer.class, player.getDefenseStrength());

        Exception exception = assertThrows(InvalidClassSelection.class,
                () -> factory.createPlayer("PlayerB", PlayerType.values().length + 1, 1));
        assertEquals("Invalid class selection", exception.getMessage());
    }
}
