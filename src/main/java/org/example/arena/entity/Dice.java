package org.example.arena.models;

public class Dice {
    private final int sides;

    public Dice() {
        sides = 6;
    }

    public int roll() {
        return (int) (Math.random() * sides + 1);
    }
}
