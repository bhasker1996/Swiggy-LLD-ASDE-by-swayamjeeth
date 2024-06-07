package org.example.arena;

import org.example.arena.entity.PlayerType;
import org.example.arena.utils.PlayerPrototypeRegistry;
import org.example.arena.entity.Player;

import java.util.Scanner;

public class GameView {
    private final Scanner scanner;
    private final PlayerPrototypeRegistry registry;

    public GameView(PlayerPrototypeRegistry registry) {
        this.registry = registry;
        scanner = new Scanner(System.in);
    }

    public void displayTitleScreen() {
        String[] lines = new String[]{
                """
                  /     \\ _____     ____ |__| ____     /  _  \\_______   ____   ____ _____  \s
                 /  \\ /  \\\\__  \\   / ___\\|  |/ ___\\   /  /_\\  \\_  __ \\_/ __ \\ /    \\\\__  \\ \s
                /    Y    \\/ __ \\_/ /_/  >  \\  \\___  /    |    \\  | \\/\\  ___/|   |  \\/ __ \\_
                \\____|__  (____  /\\___  /|__|\\___  > \\____|__  /__|    \\___  >___|  (____  /
                        \\/     \\//_____/         \\/          \\/            \\/     \\/     \\/\s
                """
        };
        System.out.println();
        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println("=============================================================================");
        System.out.println();
    }

    public void displayRules() {
        System.out.println("Rules of the Game:");
        System.out.println("1. Each player chooses a class out of the available classes. Each class has a different set of attributes for attack, defense and health.");
        System.out.println("2. Players take turns attacking and defending. The player with lower health starts the game.");
        System.out.println("3. Each round involves the attacking and defending player rolling a dice to get a multiplier");
        System.out.println("4. The attack stat of the attacking player and defense stat of the defending player are increased by their respective multipliers.\n" +
                "\tSurplus damage, if any, is reduced from the defending player's health");
        System.out.println("5. First player to reduce the opponent's health to 0 wins.");
        System.out.println();
    }

    public void displayClasses() {
        System.out.println("Available Classes:");
        for (PlayerType type : PlayerType.values()) {
            Player currType = registry.getPrototype(type);
            System.out.printf("%d. %s (Attack: %d | Defense: %d | Health: %d)%n",
                    type.ordinal() + 1, type, currType.getAttackPower(), currType.getDefenseStrength(), currType.getHealth());
        }
        System.out.println();
    }

    public String promptPlayerName(int playerNumber) {
        System.out.println();
        System.out.print("Enter name for Player " + playerNumber + ": ");
        String playerName = scanner.nextLine().trim();
        while (playerName.isEmpty()) {
            System.out.print("Name cannot be empty. Enter name for Player " + playerNumber + ": ");
            playerName = scanner.nextLine().trim();
        }
        return playerName;
    }

    public int promptPlayerClass() {
        int chosenClass;
        while (true) {
            System.out.print("Choose your class (1-" + PlayerType.values().length + "): ");
            if (scanner.hasNextInt()) {
                chosenClass = scanner.nextInt();
                scanner.nextLine();
                if (chosenClass >= 1 && chosenClass <= PlayerType.values().length) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please select a number between 1 and " + PlayerType.values().length + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        return chosenClass;
    }

    public void displayDiceRoll(String playerName, int roll) {
        System.out.println(playerName + " rolled dice. Result - " + roll);
    }

    public void displayAttackResult(String attacker, int attackDamage, String defender, int defensePower, int damageTaken, int defenderHealth) {
        System.out.println(attacker + " attacks with " + attackDamage + " damage.");
        System.out.println(defender + " defends with " + defensePower + " defense.");
        System.out.println(defender + " takes " + damageTaken + " damage, remaining health: " + defenderHealth);
    }

    public void displayWinner(String winner) {
        System.out.println();
        System.out.println(winner + " has won the game!");
    }

    public String promptPlayAgain() {
        System.out.println();
        System.out.print("Do you want to play again? (yes/no): ");
        String response = scanner.next();
        scanner.nextLine();
        return response;
    }
}
