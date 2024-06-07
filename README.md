# Magic Arena - Low Level Design Assignment

This repository comprises the Low Level Design implementation for a turn-based 2 player game called Magic Arena. The source code is crafted in Java, with unit tests utilizing Junit5, and Maven as the build automation tool.

Note: This implementation did not clear the assessment.

## Project Overview

The aim is to design a Magical Arena where players engage in turn-based combat. Each player possesses 3 attributes which are: "health", "strength", and "attack"; all represented by positive integers. A player is eliminated from the game when their health reaches zero.

In the arena, any two players can engage in a match. Players alternate between attacking and defending. The attacking player rolls an attacking dice, while the defending player rolls a defending dice. The damage inflicted by the attacker is determined by multiplying their "attack" value with the outcome of the attacking dice roll. Similarly, the defender's "strength" value, multiplied by the outcome of the defending dice, mitigates the damage. Any surplus damage not defended by the defender reduces their health. The game concludes when any player's health hits zero.

At the outset of a match, the player with lower health initiates the attack.

## How to Play

### Game Rules
1. Each player selects a class from the available options, each with distinct attributes for attack, defense, and health.
2. Players alternate between attacking and defending, commencing with the player with lower health.
3. Every round involves rolling dice for both the attacking and defending players to determine multipliers.
4. The attacking player's attack stat and the defending player's defense stat are amplified by their respective dice outcomes.
   Any surplus damage is deducted from the defending player's health.
5. The first player to deplete their opponent's health to zero is the victor.

### Available Classes
1. **Warrior** - High Health, Moderate Attack, High Defense
2. **Assassin** - Moderate Health, High Attack, Moderate Defense
3. **Healer** - Very High Health, Low Attack, High Defense
4. **Mage** - Low Health, Very High Attack, Low Defense

### Installation Guide

- Open your preferred IDE supporting Java and Maven, such as IntelliJ IDEA or Eclipse.
- Load the project into your IDE. In IntelliJ IDEA, navigate: File -> Open -> Select the project directory -> Click 'OK'. In Eclipse, go to: File -> Import -> Choose 'Existing Maven Project' -> Click 'Next' -> Browse and select the project directory -> Click 'Finish'.
- Perform a Maven clean installation. Run 'mvn clean install' from the terminal or use the IDE's GUI.
- Navigate to src -> main -> java -> org -> example -> arena -> MagicArena.java
- Execute MagicArena.java to start the game.
