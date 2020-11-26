package engine;

import play.ManualStrategy;
import play.Strategy;
import play.TimStrategy;

import java.util.Scanner;

public class TicTacToe {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.play(new TimStrategy(Player.X), new TimStrategy(Player.O));
    }

    private void play(Strategy startingPlayer, Strategy player2) {
        Game game = new Game();
        game.startNewGame(startingPlayer.getPlayer());
        Strategy currentPlayer = startingPlayer;

        while (!game.isGameOver()) {
            System.out.println(game);
            System.out.println("To Move: " + currentPlayer.getName());
            Move nextMove = currentPlayer.getMove(game);
            if (!game.makeMove(nextMove)) {
                System.out.println("\nAttempting invalid move. Try again: " + nextMove);
                continue;
            }
            System.out.println("Making move: " + nextMove);
            if (currentPlayer == startingPlayer) {
                currentPlayer = player2;
            } else {
                currentPlayer = startingPlayer;
            }
        }
        System.out.println(game);
    }
}
