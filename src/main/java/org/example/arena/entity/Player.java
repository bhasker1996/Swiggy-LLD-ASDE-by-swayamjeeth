package org.example.arena.entity;

public class Player {
    private final String name;
    private final int id;
    private final int defenseStrength;
    private final int attackPower;
    private int health;
    private final PlayerType type;

    private Player(Builder builder) {
        this.name = builder.name;
        this.id = builder.id;
        this.defenseStrength = builder.strength;
        this.attackPower = builder.attack;
        this.health = builder.health;
        this.type = builder.type;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getDefenseStrength() {
        return defenseStrength;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getHealth() {
        return health;
    }

    public PlayerType getType() {
        return type;
    }

    public static class Builder {
        private String name;
        private int id;
        private int strength;
        private int attack;
        private int health;
        private PlayerType type;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setDefenseStrength(int strength) {
            this.strength = strength;
            return this;
        }

        public Builder setAttackPower(int attack) {
            this.attack = attack;
            return this;
        }

        public Builder setHealth(int health) {
            this.health = health;
            return this;
        }

        public Builder setType(PlayerType type) {
            this.type = type;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }

    public Player clone(String name, int id) {
        return new Player.Builder()
                .setName(name)
                .setId(id)
                .setHealth(this.health)
                .setAttackPower(this.attackPower)
                .setDefenseStrength(this.defenseStrength)
                .setType(this.type).build();
    }

    public void takeDamage(int damage) {
        health = Math.max(health - damage, 0);
    }

    public boolean isDead() {
        return health == 0;
    }
}
