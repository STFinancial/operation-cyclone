package play;

import engine.Game;
import engine.Move;

import java.util.Random;

public class TimStrategy extends Strategy {
    private Random r = new Random();

    @Override
    Move getMove(Game game) {
        return new Move(r.nextInt(3), r.nextInt(3));
    }

    @Override
    String getName() {
        return "Teeeim";
    }
}
