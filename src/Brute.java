import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Brute {

    public static void main(String[] args){
        // rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);

        List<Point> points= new ArrayList<Point>();
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

        for (int p = 0; p < points.size()-1; p++) {
            for (int q = 1; q < points.size()-1; q++) {

                if (points.get(q).compareTo(points.get(p)) == 0) continue;

                for (int r = 2; r < points.size()-1; r++) {

                    if (points.get(r).compareTo(points.get(q)) == 0 || points.get(r).compareTo(points.get(p)) == 0)
                        continue;

                    for (int s = 3; s < points.size()-1; s++) {
                        if (points.get(s).compareTo(points.get(r)) == 0 || points.get(s).compareTo(points.get(q)) == 0
                                || points.get(s).compareTo(points.get(p)) == 0) continue;

                        double slope1 = points.get(p).slopeTo(points.get(q));
                        double slope2 = points.get(p).slopeTo(points.get(r));
                        double slope3 = points.get(p).slopeTo(points.get(s));


                        if (slope1 == slope2 && slope1 == slope3 && slope2 == slope3) {
                            points.get(p).drawTo(points.get(q));
                            points.get(p).drawTo(points.get(r));
                            points.get(p).drawTo(points.get(s));
                            StdDraw.show(0);
                            LinkedList<Point> line = new LinkedList<Point>();
                            line.add(points.get(p));
                            line.add(points.get(q));
                            line.add(points.get(r));
                            line.add(points.get(s));

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
                }
            }
        }

        StdDraw.show(0);
    }
}
