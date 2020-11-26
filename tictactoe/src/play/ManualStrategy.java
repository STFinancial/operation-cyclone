package play;

import engine.Game;
import engine.Move;

import java.util.Scanner;

final class ManualStrategy extends Strategy {
    private Scanner scanner = new Scanner(System.in);

    @Override
    Move getMove(Game game) {
        System.out.print("Row: ");
        int row = scanner.nextInt();
        System.out.print("Column: ");
        int column = scanner.nextInt();
        return new Move(row, column);
    }

    @Override
    String getName() {
        return "Manual Strategy";
    }
}
