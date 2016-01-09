package de.darkened.projecteuler.problems;

import de.darkened.projecteuler.util.Digits;
import de.darkened.projecteuler.util.Timer;

public class P0032 {
    
    public static void main(String[] args) {
        Timer.start();
        
        int bound = 10000;
        int productSum = 0;
        boolean[] productFound = new boolean[bound];
        for (int i = 1; i < bound; i++) {
            for (int j = 1; j < bound / i; j++) {
                int product = i * j;
                if (product < bound && !productFound[product]) {
                    if (Digits.isPandigital(new int[] {i, j, product})) {
                        productFound[product] = true;
                        productSum += product;
                    }
                }
            }
        }
        System.out.println(productSum);
        
        Timer.stop();
    }

}
