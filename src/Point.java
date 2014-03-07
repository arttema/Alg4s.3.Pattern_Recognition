import java.util.Comparator;

public class Point implements Comparable<Point> {
    // compare points by slope to this point
    public final Comparator<Point> SLOPE_ORDER = null;
    // construct the point (x, y)
    public Point(int x, int y) {
    }
    // draw this point
    public void draw() {
    }
    // draw the line segment from this point to that point
    public void drawTo(Point that) {
    }
    // string representation
    public String toString() {
        return null;
    }
    // is this point lexicographically smaller than that point?
    public int compareTo(Point that) {
        return 0;
    }
    // the slope between this point and that point
    public double slopeTo(Point that) {
        return 0;
    }
}