package org.example.arena.utils;

import org.example.arena.models.Player;

public class PlayerFactory {
    private final PlayerPrototypeRegistry playerTypes;

    public PlayerFactory(PlayerPrototypeRegistry playerTypes) {
        this.playerTypes = playerTypes;
    }

    public Player createPlayer(String playerName, String type, int id) {
        Player prototype = playerTypes.getPrototype(type);
        if (prototype != null) {
            return prototype.clone(playerName, id);
        }
        throw new IllegalArgumentException("Unknown player type: " + type);
    }

}
