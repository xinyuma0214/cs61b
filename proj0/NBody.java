import java.util.Scanner;
public class NBody {
    public static double readRadius(String Filename) {
        In in = new In(Filename);
        int firstItemInFile = in.readInt();
        double secondItemInFile = in.readDouble();
        return secondItemInFile;
    }

    public static Body[] readBodies(String Filename) {
        In in = new In(Filename);
        int firstItemInFile = in.readInt();
        double secondItemInFile = in.readDouble();
        Body[] allBodys = new Body[5];
        for (int i = 0; i < 5; i++) {
            allBodys[i] = new Body(in.readDouble(), in.readDouble(), in.readDouble(),
                    in.readDouble(), in.readDouble(), in.readString());
        }
        return allBodys;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        /*read*/
        Body[] allBodys = NBody.readBodies(filename);
        String imageToDraw = "images/starfield.jpg";
        double radius = NBody.readRadius(filename);


        /* draw bg*/
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, imageToDraw);
        /** Draw Planets*/
        StdDraw.show();
        for (Body planet : allBodys) {
            planet.draw();
        }
        /*animation*/
        StdDraw.enableDoubleBuffering();

        for (double t = 0; t <= T; t += dt) {
            double[] xForces = new double[5];
            double[] yForces = new double[5];
            for (int i = 0; i < 5; i++) {
                xForces[i] = allBodys[i].calcNetForceExertedByX(allBodys);
                yForces[i] = allBodys[i].calcNetForceExertedByY(allBodys);
            }
            for (int i = 0; i < 5; i++) {
                allBodys[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, imageToDraw);
            int j = 0;
            while (j < 5) {
                allBodys[j].draw();
                j += 1;
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        StdOut.printf("%d\n", allBodys.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < allBodys.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    allBodys[i].xxPos, allBodys[i].yyPos, allBodys[i].xxVel,
                    allBodys[i].yyVel, allBodys[i].mass, allBodys[i].imgFileName);
        }

    }
}
