package solutions.day05;

import utils.Pair;
import utils.Point;

import java.util.ArrayList;

public class VentLine {
    protected final ArrayList<Point> points;

    public VentLine(String line, boolean applyDiagonals) {
        var pair = parse(line);
        var first = pair.first;
        var second = pair.second;

        points = new ArrayList<>();

        // vertical
        if (first.x == second.x) {
            addVerticalPoints(points, first, second);
        }
        // horizontal
        else if (first.y == second.y) {
            addHorizontalPoints(points, first, second);
        } else if (applyDiagonals) {
            addDiagonalPoints(points, first, second);
        }
    }

    public VentLine(String line) {
        this(line, false);
    }

    private static void addVerticalPoints(ArrayList<Point> points, Point first, Point second) {
        Point p1, p2;
        if (first.y < second.y) {
            p1 = first;
            p2 = second;
        } else {
            p1 = second;
            p2 = first;
        }

        for (int i = p1.y; i <= p2.y; i++) {
            points.add(new Point(p1.x, i));
        }
    }

    private static void addHorizontalPoints(ArrayList<Point> points, Point first, Point second) {
        Point p1, p2;
        if (first.x < second.x) {
            p1 = first;
            p2 = second;
        } else {
            p1 = second;
            p2 = first;
        }

        for (int i = p1.x; i <= p2.x; i++) {
            points.add(new Point(i, p1.y));
        }
    }

    private static void addDiagonalPoints(ArrayList<Point> points, Point first, Point second) {
        int differenceX = first.x < second.x ? 1 : -1;
        int differenceY = first.y < second.y ? 1 : -1;

        int x, y;
        for (
                x = first.x, y = first.y;
                x != second.x;
                x += differenceX, y += differenceY
        ) {
            points.add(new Point(x, y));
        }
        // The loop exists before adding the last point. Add that here.
        points.add(new Point(x, y));
    }

    private static Pair<Point, Point> parse(String line) {
        int x, y;

        int commaPosition = line.indexOf(',');
        x = Integer.parseInt(line.substring(0, commaPosition));
        int spacePosition = line.indexOf(' ');
        y = Integer.parseInt(line.substring(commaPosition + 1, spacePosition));

        Point first = new Point(x, y);

        String rest = line.substring(spacePosition + 4);
        commaPosition = rest.indexOf(',');
        x = Integer.parseInt(rest.substring(0, commaPosition));
        y = Integer.parseInt(rest.substring(commaPosition + 1));

        Point second = new Point(x, y);

        return new Pair<>(first, second);
    }

    public void apply(Matrix matrix) {
        for (Point p : points) {
            matrix.add(p);
        }
    }

}
