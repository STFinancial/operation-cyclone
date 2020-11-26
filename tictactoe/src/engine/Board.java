package engine;

class Board {
    private MarkType[][] board;

    Board() {
        board = new MarkType[3][3];
        clearBoard();
    }

    /** Resets engine.Board state, should be called before a new game */
    void clearBoard() {
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 3; ++column) {
                board[row][column] = MarkType.EMPTY;
            }
        }
    }

    /** Marks the position for the Player, returns true if the position was previously empty, false if not */
    boolean markPosition(int row, int column, Player player) {
        if (board[row][column] != MarkType.EMPTY) {
            return false;
        }
        if (player == Player.X) {
            board[row][column] = MarkType.X;
        } else if (player == Player.O){
            board[row][column] = MarkType.O;
        } else {
            throw new IllegalStateException("Invalid engine.Player type attempting to mark position.");
        }
        return true;
    }

    /** Returns the Player at the given position, null if it has not been marked */
    Player get(int row, int column) {
        if (board[row][column] == MarkType.X) {
            return Player.X;
        } else if (board[row][column] == MarkType.O) {
            return Player.O;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        String output = "-------------\n";
        for (int row = 0; row < 3; ++row) {
            output += "|";
            for (int column = 0; column < 3; ++column) {
                output += " ";
                output += board[row][column].toString();
                output += " |";
            }
            output += "\n";
            output += "-------------\n";
        }
        return output;
    }

    private static enum MarkType {
        X("X"),
        O("O"),
        EMPTY(" ");

        private final String markString;

        private MarkType(String markString) {
            this.markString = markString;
        }

        @Override
        public String toString() {
            return markString;
        }
    }
}
