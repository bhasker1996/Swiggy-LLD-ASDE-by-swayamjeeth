package org.example.arena.entity;

public record TurnResult(Player attacker, Player defender, int attackRoll, int defenseRoll, int attackDamage,
                         int defensePower, int damage) {
}
