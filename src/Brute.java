import java.util.ArrayList;
import java.util.List;

public class Brute {

    public static void main(String[] args){
        // rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);

        List<Point> points= new ArrayList<Point>();
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

        //Point[] points = new Point[inputSize];
        //System.arraycopy(points, 0, points, 0, inputSize);
      //  Arrays.sort(points);
       // points[1].drawTo(points[5]);
        Point temppoint;
        for (int p = 0; p < points.size()-1; p++) {
            for (int q = 1; q < points.size()-1; q++) {
               // points[p).drawTo(points[q));
                for (int r = 2; r < points.size()-1; r++) {

                    for (int s = 3; s < points.size()-1; s++) {
                        if (points.get(s).x == 1234) {
                            System.out.println("");
                        }
                        //temppoint = points.remove(p);
                        double slope1 = points.get(p).slopeTo(points.get(q));
                        double slope2 = points.get(p).slopeTo(points.get(r));
                        double slope3 = points.get(p).slopeTo(points.get(s));
                        double slope4 = points.get(q).slopeTo(points.get(s));
                        double slope5 = points.get(r).slopeTo(points.get(s));
//                        if (points.get(p).compareTo(points.get(q)) < 0 &&
//                                points.get(q).compareTo(points.get(r)) < 0 &&
//                                points.get(r).compareTo(points.get(s)) < 0)
                            if(slope1==slope2 && slope1==slope3 && slope2==slope3 && slope4 == slope3 && slope2 ==slope5 && slope5 == slope1){
                            points.get(p).drawTo(points.get(q));
                            points.get(p).drawTo(points.get(r));
                            points.get(p).drawTo(points.get(s));
                            StdDraw.show(0);
                            System.out.println(points.get(p)+" -> "+points.get(q)+" -> "+points.get(r)+" -> "+points.get(s));
                        }
                    }
                }
            }
        }

        StdDraw.show(0);
    }
}
