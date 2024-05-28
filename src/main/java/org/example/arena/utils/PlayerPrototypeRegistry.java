package org.example.arena.utils;

import org.example.arena.models.Player;

import java.util.*;

public class PlayerPrototypeRegistry {
    private final Map<String, Player> playerClasses = new HashMap<>();

    public PlayerPrototypeRegistry() {
        createPrototypes();
    }

    private void createPrototypes() {
        playerClasses.put("Warrior", new Player.Builder().setHealth(7000).setAttackPower(350).setDefenseStrength(1500).build());
        playerClasses.put("Assassin", new Player.Builder().setHealth(5500).setAttackPower(450).setDefenseStrength(800).build());
        playerClasses.put("Mage", new Player.Builder().setHealth(4000).setAttackPower(600).setDefenseStrength(500).build());
        playerClasses.put("Healer", new Player.Builder().setHealth(8000).setAttackPower(250).setDefenseStrength(1200).build());
    }

    public Player getPrototype(String className) {
        return playerClasses.get(className);
    }
}
