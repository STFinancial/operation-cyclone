package play;

import engine.Game;
import engine.Move;

public abstract class Strategy {
    public abstract Move getMove(Game game);
    public abstract String getName();
}
