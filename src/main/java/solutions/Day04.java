package solutions;

import environment.Environment;
import solutions.day04.Board;
import utils.Pair;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day04 extends Solution {
    public Day04(Environment env) {
        super("04", env);
    }

    /**
     * Loads the bingo numbers and boards from the file.
     *
     * @return A pair containing the numbers and boards
     */
    protected Pair<ArrayList<Integer>, ArrayList<Board>> getBingoNumbers() {
        try {
            Scanner scanner = new Scanner(file);

            // Bingo values
            String[] bingoValuesStr = scanner.nextLine().split(",");
            ArrayList<Integer> bingoValues = new ArrayList<>(bingoValuesStr.length);
            for (String s : bingoValuesStr) {
                bingoValues.add(Integer.parseInt(s));
            }

            // Boards
            ArrayList<Board> boards = new ArrayList<>();
            while (scanner.hasNextLine()) {
                // Consumes the first empty line
                scanner.nextLine();

                Board.Builder builder = new Board.Builder();
                builder.addRow(scanner.nextLine());
                builder.addRow(scanner.nextLine());
                builder.addRow(scanner.nextLine());
                builder.addRow(scanner.nextLine());
                builder.addRow(scanner.nextLine());

                boards.add(builder.build());
            }

            return new Pair<>(bingoValues, boards);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Day04 getBingoNumbers: Error opening file.");
        }
    }

    protected String firstPart(Pair<ArrayList<Integer>, ArrayList<Board>> values) {
        Board winningBoard = null;
        int winningNumber = -1;
        mainLoop:
        for (int number : values.first) {
            for (Board board : values.second) {
                board.markNumber(number);
                if (board.isWinner()) {
                    winningBoard = board;
                    winningNumber = number;
                    break mainLoop;
                }
            }
        }
        if (winningBoard == null) {
            throw new RuntimeException("Winner board not found.");
        }
        int result = winningBoard.getUnmarkedSum() * winningNumber;
        return result + "";
    }

    @Override
    public Pair<String, String> solve() {
        Pair<ArrayList<Integer>, ArrayList<Board>> values = getBingoNumbers();
        return new Pair<>(firstPart(values), null);
    }
}
