package de.darkened.projecteuler.problems;

import de.darkened.projecteuler.util.Digits;
import de.darkened.projecteuler.util.Timer;

public class P0055 {
    
    public static void main(String[] args) {
        Timer.start();
        
        long bound = 10000;
        int threshold = 50;
        long count = 0;
        for (long start = 1; start < bound; start++) {
            long current = start;
            long reverse = Digits.reverse(current);
            long iteration = 0;
            do {
                current += reverse;
                reverse = Digits.reverse(current);
                iteration++;
                assert current >= 0;
            } while (current != reverse && iteration < threshold);
            if (iteration >= threshold) {
                System.out.println("Lychrel: " + start);
                count++;
            }
        }
        System.out.println(count);
        
        Timer.stop();
    }

}
