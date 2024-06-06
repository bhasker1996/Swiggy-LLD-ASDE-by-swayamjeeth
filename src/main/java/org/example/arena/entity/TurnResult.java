package org.example.arena.models;

public record TurnResult(Player attacker, Player defender, int attackRoll, int defenseRoll, int attackDamage,
                         int defensePower, int damage) {
}
