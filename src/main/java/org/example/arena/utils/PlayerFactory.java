package org.example.arena.utils;

import org.example.arena.exceptions.InvalidClassSelection;
import org.example.arena.models.Player;
import org.example.arena.models.PlayerType;

public class PlayerFactory {
    private final PlayerPrototypeRegistry playerPrototypes;

    public PlayerFactory(PlayerPrototypeRegistry playerPrototypes) {
        this.playerPrototypes = playerPrototypes;
    }

    public Player createPlayer(String playerName, int userSelectionType, int id) {
        if(userSelectionType < 1 || userSelectionType > PlayerType.values().length) {
            throw new InvalidClassSelection("Invalid class selection");
        }
        PlayerType type = PlayerType.values()[userSelectionType - 1];
        Player prototype = playerPrototypes.getPrototype(type);
        return prototype.clone(playerName, id);
    }
}
