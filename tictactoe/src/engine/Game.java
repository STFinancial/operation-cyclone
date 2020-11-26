package engine;

public class Game {
    private Board board;
    private Player currentTurn;

    public Game() {
        this.board = new Board();
        board.clearBoard();
        currentTurn = Player.X;
    }

    public void startNewGame(Player startingPlayer) {
        this.currentTurn = startingPlayer;
        board.clearBoard();
    }

    // TODO: Should this take Player and then we remove "currentTurn" from this class?
    /** Returns true if the spot we want to move is empty, otherwise return false */
    public boolean makeMove(int row, int column) {
        if (row > 2 || row < 0) {
            return false;
        }
        if (column > 2 || column < 0) {
            return false;
        }
        if (!board.markPosition(row, column, currentTurn)) {
            return false;
        }
        currentTurn = currentTurn == Player.X ? Player.O : Player.X;
        return true;
    }

    /** Returns true if there is a winner or if all spots have been marked, false otherwise */
    public boolean isGameOver() {
        // TODO: Do a more sophisticated cat's game check.
        if (getWinner() == null) {
            for (int row = 0; row < 3; ++row) {
                for (int column = 0; column < 3; ++column) {
                    if (board.get(row, column) == null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /** If a winner is present, returns the Player, otherwise returns null */
    public Player getWinner() {
        Player player;
        // Check rows
        for (int row = 0; row < 3; ++row) {
            player = board.get(row, 0);
            if (player != null) {
                if (player == board.get(row, 1) && player == board.get(row, 2)) {
                    return player;
                }
            }
        }
        // Check columns
        for (int column = 0; column < 3; ++column) {
            player = board.get(0, column);
            if (player != null) {
                if (player == board.get(1, column) && player == board.get(2, column)) {
                    return player;
                }
            }
        }

        // Check diagonals
        player = board.get(0, 0);
        if (player == board.get(1, 1) && player == board.get(2, 2)) {
            return player;
        }
        player = board.get(0, 2);
        if (player == board.get(1, 1) && player == board.get(2, 0)) {
            return player;
        }
        return null;
    }

    @Override
    public String toString() {
        String output = board.toString();
        if (isGameOver()) {
            Player winner = getWinner();
            if (winner == null) {
                output += "Cat's Game :3";
            } else {
                output += "Winner: " + winner.toString() + "\n";
            }
        } else {
            output += "Current Turn: " + currentTurn.toString();
        }
        return output;
    }
}
