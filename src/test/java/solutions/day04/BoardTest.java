package solutions.day04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    @DisplayName("builder.addRow should add the values correctly")
    public void testBuilderAddRow() {
        Board.Builder builder = new Board.Builder();
        builder.addRow("    22   13 17  11  0");
        Assertions.assertEquals(22, builder.board.get(0).get(0).first);
        Assertions.assertEquals(13, builder.board.get(0).get(1).first);
        Assertions.assertEquals(17, builder.board.get(0).get(2).first);
        Assertions.assertEquals(11, builder.board.get(0).get(3).first);
        Assertions.assertEquals(0, builder.board.get(0).get(4).first);
    }

    @Test
    @DisplayName("builder should throw if called with less than 5 rows")
    public void testBuilderWithFewerThan5Rows() {
        try {
            Board.Builder builder = new Board.Builder();
            builder.addRow("22 13 17 11  0");
            builder.addRow(" 8  2 23  4 24");
            builder.addRow("21  9 14 16  7");
            builder.addRow(" 6 10  3 18  5");
            builder.build();
            Assertions.fail();
        } catch (RuntimeException e) {
            Assertions.assertEquals("Board.Builder: Insufficient rows", e.getMessage());
        }
    }

    @Test
    @DisplayName("builder should return a correct board")
    public void testBuilder5Rows() {
        Board.Builder builder = new Board.Builder();
        builder.addRow("22 13 17 11  0");
        builder.addRow(" 8  2 23  4 24");
        builder.addRow("21  9 14 16  7");
        builder.addRow(" 6 10  3 18  5");
        builder.addRow(" 1 12 20 15 19");
        {
            Assertions.assertEquals(22, builder.board.get(0).get(0).first);
            Assertions.assertEquals(13, builder.board.get(0).get(1).first);
            Assertions.assertEquals(17, builder.board.get(0).get(2).first);
            Assertions.assertEquals(11, builder.board.get(0).get(3).first);
            Assertions.assertEquals(0, builder.board.get(0).get(4).first);
        }
        {
            Assertions.assertEquals(8, builder.board.get(1).get(0).first);
            Assertions.assertEquals(2, builder.board.get(1).get(1).first);
            Assertions.assertEquals(23, builder.board.get(1).get(2).first);
            Assertions.assertEquals(4, builder.board.get(1).get(3).first);
            Assertions.assertEquals(24, builder.board.get(1).get(4).first);

        }
        {
            Assertions.assertEquals(21, builder.board.get(2).get(0).first);
            Assertions.assertEquals(9, builder.board.get(2).get(1).first);
            Assertions.assertEquals(14, builder.board.get(2).get(2).first);
            Assertions.assertEquals(16, builder.board.get(2).get(3).first);
            Assertions.assertEquals(7, builder.board.get(2).get(4).first);
        }
        {
            Assertions.assertEquals(6, builder.board.get(3).get(0).first);
            Assertions.assertEquals(10, builder.board.get(3).get(1).first);
            Assertions.assertEquals(3, builder.board.get(3).get(2).first);
            Assertions.assertEquals(18, builder.board.get(3).get(3).first);
            Assertions.assertEquals(5, builder.board.get(3).get(4).first);
        }
        {
            Assertions.assertEquals(1, builder.board.get(4).get(0).first);
            Assertions.assertEquals(12, builder.board.get(4).get(1).first);
            Assertions.assertEquals(20, builder.board.get(4).get(2).first);
            Assertions.assertEquals(15, builder.board.get(4).get(3).first);
            Assertions.assertEquals(19, builder.board.get(4).get(4).first);
        }
        builder.build();
    }

    @Test
    @DisplayName("markNumber should modify the board")
    public void testMarkNumber() {
        Board.Builder builder = new Board.Builder();
        builder.addRow("22 13 17 11  0");
        builder.addRow(" 8  2 23  4 24");
        builder.addRow("21  9 14 16  7");
        builder.addRow(" 6 10  3 18  5");
        builder.addRow(" 1 12 20 15 19");
        Board board = builder.build();
        board.markNumber(3);
        Assertions.assertEquals(true, board.board.get(3).get(2).second);
    }

    @Test
    @DisplayName("isWinner should work")
    public void testIsWinner() {
        Board.Builder builder = new Board.Builder();
        builder.addRow("22 13 17 11  0");
        builder.addRow(" 8  2 23  4 24");
        builder.addRow("21  9 14 16  7");
        builder.addRow(" 6 10  3 18  5");
        builder.addRow(" 1 12 20 15 19");
        Board board = builder.build();
        board.markNumber(22);
        board.markNumber(13);
        board.markNumber(17);
        board.markNumber(11);
        board.markNumber(0);
        Assertions.assertTrue(board.isWinner());
    }

    @Test
    @DisplayName("getUnmarkedSum should return the correct value")
    public void testGetUnmarkedSum() {
        Board.Builder builder = new Board.Builder();
        builder.addRow("22 13 17 11  0");
        builder.addRow(" 8  2 23  4 24");
        builder.addRow("21  9 14 16  7");
        builder.addRow(" 6 10  3 18  5");
        builder.addRow(" 1 12 20 15 19");
        Board board = builder.build();
        board.markNumber(22);
        board.markNumber(13);
        board.markNumber(17);
        board.markNumber(0);
        board.markNumber(11);
        int sum = board.getUnmarkedSum();
        Assertions.assertEquals(237, sum);
    }

}
