package play;

import engine.Game;
import engine.Player;

import java.util.Scanner;

public class Play {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Play p = new Play();
        p.playManually();
    }

    private void playManually() {
        Game game = new Game();
        game.startNewGame(Player.X);

        while (!game.isGameOver()) {
            System.out.println(game);
            System.out.println("Next move at: ");
            System.out.print("Row: ");
            int row = scanner.nextInt();
            System.out.print("Column: ");
            int column = scanner.nextInt();
            if (!game.makeMove(row, column)) {
                System.out.println("\nInvalid move. Try again.");
                continue;
            }
        }
        System.out.println(game);
    }
}
