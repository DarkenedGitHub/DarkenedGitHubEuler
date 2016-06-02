package de.darkened.projecteuler.problems;

import de.darkened.projecteuler.util.Digits;
import de.darkened.projecteuler.util.Timer;

public class P0092 {

    public static void main(String[] args) {
        Timer.start();
        
        int bound = 10000000;
        System.out.println(bruteForce(bound));
        Timer.stop();
        System.out.println(cached(bound)); // not much faster
        Timer.stop();

    }
    
    private static int cached(int bound) {
        int maxDigits = (int) Math.ceil(Math.log10(bound - 1));
        int maxIntermediate = 9 * 9 * maxDigits;
        int[] end = new int[maxIntermediate];
        end[0] = 1;
        end[88] = 89;
        for (int start = 1; start <= maxIntermediate; start++) {
            int current = start;
            while (end[current - 1] == 0) {
                current = Digits.digitSquareSum(current);
            }
            end[start - 1] = end[current - 1];
        }
        int count = 0;
        for (int start = 1; start < bound; start++) {
            if (end[Digits.digitSquareSum(start) - 1] == 89) {
                count++;
            }
        }
        return count;
    }

    private static int bruteForce(int bound) {
        int count = 0;
        for (int start = 1; start < bound; start++) {
            int current = start;
            while (current != 1 && current != 89) {
                current = Digits.digitSquareSum(current);
            }
            if (current == 89) {
                count++;
            }
        }
        return count;
    }
    
}
