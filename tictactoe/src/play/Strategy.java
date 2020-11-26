package play;

import engine.Game;
import engine.Move;

abstract class Strategy {
    abstract Move getMove(Game game);
    abstract String getName();
}
