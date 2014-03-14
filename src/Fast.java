import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Fast {
    public static void main(String[] args) {

        // rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);

        List<Point> points = new ArrayList<Point>();
        // read in the points
        int inputSize = 0;
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            p.draw();
            points.add(p);
            inputSize++;
        }

        Point pointP;
        for (int p = 0; p < points.size(); p++) {

            pointP = points.get(p);
            points.remove(p);
            for (int q = 0; q < points.size(); q++) {
                Point pointQ = points.get(q);
//                if (pointQ.compareTo(pointP) == 0) continue;

                Collections.sort(points, pointP.SLOPE_ORDER);
                Collections.sort(points, Collections.reverseOrder());

                LinkedList<Point> line = new LinkedList<Point>();
                line.add(pointP);

                for (Point point : points) {
                    if (point.slopeTo(pointP) == pointQ.slopeTo(pointP)) {
                        line.add(point);
                    }
                    else break;
                }

                if (line.size() >= 4) {
                    Collections.sort(line);
                    line.getFirst().drawTo(line.getLast());
                    StdDraw.show(0);
                    String output = line.get(0).toString();
                    for (int i = 1; i < line.size(); i++) {
                        Point point = line.get(i);
                        output += "->" + point;
                    }
                    System.out.println(output);
                }
            }
           // points.add(pointP);
        }

        StdDraw.show(0);
    }
}
