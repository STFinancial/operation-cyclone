package play;

import engine.Game;
import engine.Move;
import engine.Player;

import java.util.Random;

public class TimStrategy extends Strategy {
    private Random r = new Random();

    public TimStrategy(Player player) {
        super(player);
    }

    @Override
    public Move getMove(Game game) {
        int row;
        int column;
        do {
            row = r.nextInt(3);
            column = r.nextInt(3);
        } while (game.getBoardState()[row][column] != null);
        return new Move(row, column);
    }

    @Override
    public String getName() {
        return "Teeeim";
    }
}
