package de.darkened.projecteuler.problems;

import java.util.Arrays;

import de.darkened.projecteuler.util.Timer;

public class P0044 {
    
    public static void main(String[] args) {
        Timer.start();
        
        int bound = 10000;
        int[] pentagonal = new int[bound];
        for (int i = 0; i < bound; i++) {
            pentagonal[i] = ((i + 1) * (3 * (i + 1) - 1)) / 2;
        }
        
        int result = 0;
        for (int i = 0; i < bound && result == 0; i++) {
            for (int j = 0; j < bound && result == 0; j++) {
                if (Arrays.binarySearch(pentagonal, pentagonal[i] + pentagonal[j]) >= 0 && 
                        Arrays.binarySearch(pentagonal, 2 * pentagonal[i] + pentagonal[j]) >= 0) {
                    result = pentagonal[j];
                }
            }
        }
        System.out.println(result);
        
        Timer.stop();
    }

}
