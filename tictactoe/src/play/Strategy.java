package play;

import engine.Game;
import engine.Move;
import engine.Player;

public abstract class Strategy {
    private final Player player;

    public Strategy(Player player) { this.player = player; }

    public abstract Move getMove(Game game);
    public abstract String getName();

    public Player getPlayer() {
        return player;
    }
}
