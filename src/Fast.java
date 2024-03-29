import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Fast {
    // todo problems with vertical only, horizontal only,
    // todo eliminate extra duplicate segments everywhere
    public static void main(String[] args) {

        // rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);

        List<Point> points = new ArrayList<Point>();
        // read in the points
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();

        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            p.draw();
            points.add(p);
        }

        Collections.sort(points);
        Point pointP;
        int size = points.size();
        for (int p = 0; p < size; p++) {

            pointP = points.get(p);
            for (int q = 0; q < size; q++) {
                Point pointQ = points.get(q);

                Collections.sort(points.subList(q + 1, size));
                Collections.sort(points.subList(q + 1, size), pointP.SLOPE_ORDER);
                //Collections.sort(points, Collections.reverseOrder());

                LinkedList<Point> line = new LinkedList<Point>();
                line.add(pointP);
                line.add(pointQ);

                for (int i1 = q + 1; i1 < size; i1++) {
                    Point point = points.get(i1);
                    if (point.slopeTo(pointP) == pointQ.slopeTo(pointP)) {
                        line.add(point);
                    } else break;
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
                points.add(pointQ);
            }
            points.add(pointP);
        }

        StdDraw.show(0);
    }
}
//if (pointQ.compareTo(pointP) == 0) continue;
