public class Brute {

    public static void main(String[] args){
        // rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);

        // read in the input
        int inputSize = 0;
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] input = new Point[200];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            p.draw();
            input[i] = p;
            inputSize++;
        }

        Point[] points = new Point[inputSize];
        System.arraycopy(input, 0, points, 0, inputSize);
       // points[1].drawTo(points[5]);
        for (int p = 0; p < points.length-1; p++) {
            for (int q = 0; q < points.length-1; q++) {
               // points[p].drawTo(points[q]);
                for (int r = 0; r < points.length-1; r++) {
                    for (int s = 0; s < points.length-1; s++) {
                        double slope1 = points[p].slopeTo(points[q]);
                        double slope2 = points[p].slopeTo(points[r]);
                        double slope3 = points[p].slopeTo(points[s]);
                        if(slope1==slope2 && slope1==slope3 && slope2==slope3){
                            points[p].drawTo(points[q]);
                            points[p].drawTo(points[r]);
                            points[p].drawTo(points[s]);
                            StdDraw.show(0);
                            System.out.println(points[p]+" -> "+points[q]+" -> "+points[r]+" -> "+points[s]);
                        }
                    }
                }
            }
        }

        StdDraw.show(0);
    }
}
