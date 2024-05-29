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
        playerClasses.put(PlayerType.Warrior, new Player.Builder().setHealth(3000).setAttackPower(350).setDefenseStrength(500).setType(PlayerType.Warrior).build());
        playerClasses.put(PlayerType.Assassin, new Player.Builder().setHealth(2250).setAttackPower(450).setDefenseStrength(300).setType(PlayerType.Assassin).build());
        playerClasses.put(PlayerType.Mage, new Player.Builder().setHealth(1500).setAttackPower(600).setDefenseStrength(150).setType(PlayerType.Mage).build());
        playerClasses.put(PlayerType.Healer, new Player.Builder().setHealth(3500).setAttackPower(250).setDefenseStrength(400).setType(PlayerType.Healer).build());
    }

    public Player getPrototype(PlayerType playerType) {
        return playerClasses.get(playerType);
    }
}
