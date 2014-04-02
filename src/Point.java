import java.util.Comparator;

public class Point implements Comparable<Point> {
    // compare points by slope to this point
   public final Comparator<Point> SLOPE_ORDER = new SlopeComparator();

    private final int x;
    private final int y;

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // draw this point
    public void draw() {
          /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw the line segment from this point to that point
    public void drawTo(Point that) {
          /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // string representation
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        int x1 = that.x, y1 = that.y;

        if (y < y1) return -1;
        else if (y == y1 && x < x1) return -1;
        else if (y == y1 && x == x1) return 0;
        else return 1;
    }

    // the slope between this point and that point
    public double slopeTo(Point that) {
        double y0 = this.y, x0 = this.x;
        double y1 = that.y, x1 = that.x;

        if (y1 == y0 && x1 == x0) return Double.NEGATIVE_INFINITY;
        if (x1 == x0 ) return Double.POSITIVE_INFINITY;
        if (y1 == y0 ) {
            double a = 1.0;
            return (a-a)/a; //positive zero
        }
        return (y1 - y0)/(x1 - x0);
    }
    /**
    *  sign of compare(), where p, q, and r have coordinates in [0, 500)
      -  wrong order: slope-descending
  *  sign of compare(), where p, q, and r have coordinates in [0, 32768)
      -  wrong order: slope-descending
  *  sign of compare(), where p, q, and r have coordinates in [0, 10)
      -  wrong order: slope-descending
     */
    private class SlopeComparator implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
//            double y0 = y, x0 = x;
//            double y1 = o1.y, x1 = o1.x;
//            double y2 = o2.y, x2 = o2.x;
//
            double slopeToO1 = slopeTo(o1);
            double slopeToO2 = slopeTo(o2);

            if(slopeToO1== slopeToO2)return 0;
            if(slopeToO1>slopeToO2)return -1;
            return 1;
//            return (int)(slopeToO1- slopeToO2);
        }
    }
}