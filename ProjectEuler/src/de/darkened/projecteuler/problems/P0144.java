package de.darkened.projecteuler.problems;

import java.io.IOException;

import de.darkened.projecteuler.util.Timer;

public class P0144 {

    public static void main(String[] args) throws IOException {
        Timer.start();

        int count = 0;
        // initially linear equation from two points
        double startX = 0.0;
        double startY = 10.1;
        double currentX = 1.4;
        double currentY = -9.6;
        double currentM = (currentY - startY) / (currentX - startX);
        double currentN = currentY - currentM * currentX;
        System.out.format("%2.2f | %2.2f\n", currentX, currentY);
        // loop while not hitting the hole
        while (Math.abs(currentX) > 0.01 || currentY < 0) {
            count++;
            double tangentM = -4 * currentX / currentY;
            double normalM = -1 / tangentM;
            double currentAlpha = Math.atan(currentM);
            double normalAlpha = Math.atan(normalM);
            double nextAlpha = 2 * normalAlpha - currentAlpha;
            // calculate next linear equation (from slope and point)
            currentM = Math.tan(nextAlpha);
            currentN = currentY - currentM * currentX;
            // calculate intersection between ellipse and linear equation
            double a = 4 + currentM * currentM;
            double b = 2 * currentM * currentN;
            double c = currentN * currentN - 100;
            double pdiv2 = b / a / 2;
            double q = c / a;
            double rootPart = Math.sqrt(pdiv2 * pdiv2 - q);
            double resX1 = -pdiv2 + rootPart;
            double resX2 = -pdiv2 - rootPart;
            // calculate next point
            currentX = Math.abs(resX1 - currentX) < Math.abs(resX2 - currentX) ? resX2 : resX1;
            currentY = currentM * currentX + currentN;
            System.out.format("%2d: %2.2f | %2.2f\n", count, currentX, currentY);
        }
        System.out.println(count);

        Timer.stop();
    }

}
