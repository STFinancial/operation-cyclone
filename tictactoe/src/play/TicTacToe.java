package play;

import engine.Game;
import engine.Move;
import engine.Player;

import java.util.Scanner;

public class TicTacToe {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.play(new ManualStrategy(), new ManualStrategy());
    }

    private void play(Strategy player1, Strategy player2) {
        Game game = new Game();
        game.startNewGame(Player.X);
        Strategy currentPlayer = player1;

        while (!game.isGameOver()) {
            System.out.println(game);
            System.out.println("To Move: " + currentPlayer.getName());
            Move nextMove = currentPlayer.getMove(game);
            if (!game.makeMove(nextMove)) {
                System.out.println("\nAttempting invalid move. Try again: " + nextMove);
                continue;
            }
            System.out.println("Making move: " + nextMove);
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
        System.out.println(game);
    }
}
