package org.example.arena;

import org.example.arena.models.Player;
import org.example.arena.models.TurnResult;
import org.example.arena.utils.PlayerFactory;
import org.example.arena.utils.PlayerPrototypeRegistry;

public class Game {
    private final GameService gameService;
    private final PlayerFactory playerFactory;
    private final GameView gameView;

    public Game() {
        this.gameService = new GameService();
        PlayerPrototypeRegistry registry = new PlayerPrototypeRegistry();
        this.playerFactory = new PlayerFactory(registry);
        this.gameView = new GameView(registry);
    }

    public void startGame() {
        gameView.displayTitleScreen();
        gameView.displayRules();
        gameView.displayClasses();

        String player1name = gameView.promptPlayerName(1);
        int player1class = gameView.promptPlayerClass();
        Player player1 = playerFactory.createPlayer(player1name, player1class, 1);

        String player2name = gameView.promptPlayerName(2);
        int player2class = gameView.promptPlayerClass();
        Player player2 = playerFactory.createPlayer(player2name, player2class, 2);
        playGame(player1, player2);
    }

    private void playGame(Player player1, Player player2) {
        Player firstPlayer = (player1.getHealth() < player2.getHealth()) ? player1 : player2;
        Player secondPlayer = (firstPlayer == player1) ? player2 : player1;

        while (!gameService.isGameOver(player1, player2)) {
            TurnResult result = gameService.playTurn(firstPlayer, secondPlayer);
            displayTurnResult(result);

            if (!gameService.isGameOver(player1, player2)) {
                result = gameService.playTurn(secondPlayer, firstPlayer);
                displayTurnResult(result);
            }
        }

        Player winner = gameService.getWinner(player1, player2);
        gameView.displayWinner(winner.getName());

        String playAgain = gameView.promptPlayAgain();
        if (playAgain.equalsIgnoreCase("yes")) {
            startGame();
        } else {
            System.out.println("Thanks for playing!");
        }
    }

    private void displayTurnResult(TurnResult result) {
        System.out.println();
        gameView.displayDiceRoll(result.attacker().getName(), result.attackRoll());
        gameView.displayDiceRoll(result.defender().getName(), result.defenseRoll());
        gameView.displayAttackResult(
                result.attacker().getName(),
                result.attackDamage(),
                result.defender().getName(),
                result.defensePower(),
                result.damage(),
                result.defender().getHealth()
        );
    }
}
