package play;

import engine.Game;
import engine.Move;
import engine.Player;

public class KristenStrategy extends Strategy {

    public KristenStrategy(Player player) {
        super(player);
    }

    @Override
    public Move getMove(Game game) {
        return null;
    }

    @Override
    public String getName() {
        return "Kristen";
    }
}
