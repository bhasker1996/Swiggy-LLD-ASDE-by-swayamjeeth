# LLD Assignment - Magic Arena

This repository contains the Low Level Design code for a turn-based 2 player game. The source code is written in Java, unit tests in Junit5 and it uses Maven as the build tool.

## Overview of Requirements

Design a Magical Arena. Every Player is defined by a “health” attribute, “strength” attribute and an “attack” attribute - all positive integers. The player dies if his health attribute touches 0.

Any two player can fight a match in the arena. Players attack in turns. Attacking player rolls the attacking dice and the defending player rolls the defending dice. The “attack”  value multiplied by the outcome of the  attacking dice roll is the damage created by the attacker. The defender “strength” value, multiplied by the outcome of the defending dice is the damage defended by the defender. Whatever damage created by attacker which is in excess of the damage defended by the defender will reduce the “health” of the defender. Game ends when any player's health reaches 0

Player with lower health attacks first at the start of a match.

