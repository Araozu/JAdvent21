package solutions.day04;

import utils.MutablePair;

import java.util.ArrayList;

public class Board {

    public static class Builder {

        private int rowCount = 0;
        protected ArrayList<ArrayList<MutablePair<Integer, Boolean>>> board;

        public Builder() {
            board = new ArrayList<>(5);
            for (int i = 0; i < 5; i++) {
                board.add(new ArrayList<>(5));
            }
        }

        /**
         * Parses a String with 5 integers into a board row.
         *
         * @param row The String to parse
         * @throws RuntimeException if this method is called more than 5 times
         */
        public void addRow(String row) {
            if (rowCount >= 5) {
                throw new RuntimeException("Board.Builder: Tried to add more than 5 rows");
            }

            String[] values = row.split(" ");
            for (String s : values) {
                if (s.equals("")) continue;

                board.get(rowCount).add(new MutablePair<>(Integer.parseInt(s), false));
            }
            rowCount++;
        }

        /**
         * Builds the board
         *
         * @return The board
         * @throws RuntimeException If addRow hasn't been called exactly 5 times
         */
        public Board build() {
            if (rowCount != 5) {
                throw new RuntimeException("Board.Builder: Insufficient rows");
            }
            return new Board(board);
        }

    }

    protected final ArrayList<ArrayList<MutablePair<Integer, Boolean>>> board;

    private Board(ArrayList<ArrayList<MutablePair<Integer, Boolean>>> board) {
        this.board = board;
    }

    public void markNumber(int number) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                MutablePair<Integer, Boolean> pair = board.get(i).get(j);
                if (pair.first == number) {
                    pair.second = true;
                }
            }
        }
    }

    private boolean getPairBoolean(ArrayList<MutablePair<Integer, Boolean>> row, int position) {
        return row.get(position).second;
    }

    private boolean checkRows() {
        for (ArrayList<MutablePair<Integer, Boolean>> row : board) {
            if (
                    getPairBoolean(row, 0) && getPairBoolean(row, 1)
                            && getPairBoolean(row, 2) && getPairBoolean(row, 3)
                            && getPairBoolean(row, 4)
            ) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 5; i++) {
            if (
                    getPairBoolean(board.get(0), i) && getPairBoolean(board.get(1), i)
                            && getPairBoolean(board.get(2), i) && getPairBoolean(board.get(3), i)
                            && getPairBoolean(board.get(4), i)
            ) {
                return true;
            }
        }
        return false;
    }

    public boolean isWinner() {
        return checkRows() || checkColumns();
    }

    public int getUnmarkedSum() {
        int sum = 0;
        for (ArrayList<MutablePair<Integer, Boolean>> row : board) {
            for (MutablePair<Integer, Boolean> pair : row) {
                if (!pair.second) {
                    sum += pair.first;
                }
            }
        }
        return sum;
    }
}
