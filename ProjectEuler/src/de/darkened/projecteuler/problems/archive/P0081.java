package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.DataLoader;
import de.darkened.projecteuler.util.Timer;

public class P0081 {

    public static void main(String[] args) {
        int[] grid = DataLoader.getNumberGridSerial(P0081.class.getSimpleName(), ",");
        int size = 80;
        int maxIndex = size * size - 1;
        Timer.start();
        
        for (int gridIndex = 1; gridIndex <= maxIndex; gridIndex++) {
            if (gridIndex < size) { // first row
                grid[gridIndex] += grid[gridIndex - 1];
            } else if (gridIndex % 80 == 0) { // first column
                grid[gridIndex] += grid[gridIndex - size];
            } else {
                grid[gridIndex] += Math.min(grid[gridIndex - size], grid[gridIndex - 1]);
            }
        }
        System.out.println(grid[maxIndex]);

        Timer.stop();
    }

}
