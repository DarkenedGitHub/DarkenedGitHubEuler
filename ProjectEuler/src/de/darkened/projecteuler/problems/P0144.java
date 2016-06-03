package de.darkened.projecteuler.problems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.darkened.projecteuler.util.Timer;
import javafx.util.Pair;

public class P0144 {

    public static void main(String[] args) throws IOException {
        Timer.start();

        int count = 0;
        List<Pair<Double, Double>> points = new ArrayList<>();
        // initially linear equation from two points
        double startX = 0.0;
        double startY = 10.1;
        double currentX = 1.4;
        double currentY = -9.6;
        double currentM = (currentY - startY) / (currentX - startX);
        double currentN = currentY - currentM * currentX;
        System.out.format("%2.5f | %2.5f\n", currentX, currentY);
        // loop while not hitting the hole
        while (Math.abs(currentX) > 0.01 || currentY < 0) {
            count++;
            points.add(new Pair<>(currentX, currentY));
            double tangentM = -4 * currentX / currentY;
            double tana = (currentM - tangentM) / (1 + currentM * tangentM);
            currentM = (tangentM - tana) / (tana * tangentM + 1);
            // calculate next linear equation (from slope and point)
            currentN = currentY - currentM * currentX;
            // calculate intersection between ellipse and linear equation
            double a = 4 + currentM * currentM;
            double b = 2 * currentM * currentN;
            double c = currentN * currentN - 100;
            double resX1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            double resX2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            // calculate next point
            currentX = Math.abs(resX1 - currentX) < Math.abs(resX2 - currentX) ? resX2 : resX1;
            currentY = currentM * currentX + currentN;
            System.out.format("%2d: %2.5f | %2.5f\n", count, currentX, currentY);
        }
        System.out.println(count);

        Timer.stop();
    }

}
