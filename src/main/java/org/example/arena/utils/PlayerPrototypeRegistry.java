package org.example.arena.utils;

import org.example.arena.models.Player;
import org.example.arena.models.PlayerType;

import java.util.*;

public class PlayerPrototypeRegistry {
    private final Map<PlayerType, Player> playerClasses = new HashMap<>();

    public PlayerPrototypeRegistry() {
        createPrototypes();
    }

    private void createPrototypes() {
        playerClasses.put(PlayerType.Warrior, new Player.Builder().setHealth(7000).setAttackPower(350).setDefenseStrength(1500).setType(PlayerType.Warrior).build());
        playerClasses.put(PlayerType.Assassin, new Player.Builder().setHealth(5500).setAttackPower(450).setDefenseStrength(800).setType(PlayerType.Assassin).build());
        playerClasses.put(PlayerType.Mage, new Player.Builder().setHealth(4000).setAttackPower(600).setDefenseStrength(500).setType(PlayerType.Mage).build());
        playerClasses.put(PlayerType.Healer, new Player.Builder().setHealth(8000).setAttackPower(250).setDefenseStrength(1200).setType(PlayerType.Healer).build());
    }

    public Player getPrototype(PlayerType playerType) {
        return playerClasses.get(playerType);
    }
}
