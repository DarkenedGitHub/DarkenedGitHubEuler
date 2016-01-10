package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.Timer;

public class P0039 {
    
    public static void main(String[] args) {
        Timer.start();
        
        int maxTriangleCount = 0;
        int bestPerimeter = 0;
        for (int p = 2; p <= 1000; p += 2) {
            int triangleCount = 0;
            int pSquare = p * p;
            int doubleP = 2 * p;
            for (int doubleA = 2; doubleA < p; doubleA += 2) {
                if ((pSquare - doubleA * p) % (doubleP - doubleA) == 0) {
                    triangleCount++;
                }
            }
            if (triangleCount > maxTriangleCount) {
                maxTriangleCount = triangleCount;
                bestPerimeter = p;
            }
        }
        System.out.println(bestPerimeter);
        
        Timer.stop();
    }

}
