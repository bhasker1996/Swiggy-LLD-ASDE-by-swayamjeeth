package org.example.arena.utils;

import org.example.arena.models.Player;
import org.example.arena.models.PlayerType;

public class PlayerFactory {
    private final PlayerPrototypeRegistry playerPrototypes;

    public PlayerFactory(PlayerPrototypeRegistry playerPrototypes) {
        this.playerPrototypes = playerPrototypes;
    }

    public Player createPlayer(String playerName, int userSelectionType, int id) {
        PlayerType type = PlayerType.values()[userSelectionType - 1];
        Player prototype = playerPrototypes.getPrototype(type);
        if (prototype != null) {
            return prototype.clone(playerName, id);
        }
        throw new IllegalArgumentException("Unknown player type: " + type);
    }
}
