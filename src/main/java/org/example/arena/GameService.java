package org.example.arena;

import org.example.arena.exceptions.GameNotOverException;
import org.example.arena.models.Dice;
import org.example.arena.models.Player;
import org.example.arena.models.TurnResult;

public class GameService {
    private final Dice dice;

    public GameService() {
        dice = new Dice();
    }

    public TurnResult playTurn(Player attacker, Player defender) {
        int attackerRoll = dice.roll();
        int defenderRoll = dice.roll();

        int attackDamage = attacker.getAttackPower() * attackerRoll;
        int absorbedDamage = defender.getDefenseStrength() * defenderRoll;

        int damage = Math.max(attackDamage - absorbedDamage, 0);
        defender.takeDamage(damage);
        return new TurnResult(attacker, defender, attackerRoll, defenderRoll, attackDamage, absorbedDamage, damage);
    }

    public boolean isGameOver(Player player1, Player player2) {
        return player1.isDead() || player2.isDead();
    }

    public Player getWinner(Player player1, Player player2) {
        if(player1.isDead()) {
            return player2;
        } else if(player2.isDead()) {
            return player1;
        } else {
            throw new GameNotOverException("Cannot determine winner for game while it is ongoing.");
        }
    }

}
