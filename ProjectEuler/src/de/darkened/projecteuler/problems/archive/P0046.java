package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.PrimeSieve;
import de.darkened.projecteuler.util.Timer;

public class P0046 {
    
    public static void main(String[] args) {
        Timer.start();
        
        int bound = 10000;
        PrimeSieve primeSieve = new PrimeSieve(bound);
        int squareBaseBound = (int) Math.sqrt(bound / 2);
        int[] doubleSquareTable = new int[squareBaseBound];
        for (int i = 0; i < squareBaseBound; i++) {
            int base = (i + 1);
            doubleSquareTable[i] = 2 * base * base;
        }
        
        int result = 0;
        for (int i = 3; i < bound && result == 0; i += 2) {
            if (!primeSieve.isValid(i)) {
                boolean composite = false;
                // check adding 2 as a prime
                double baseWhenAddingTwo = Math.sqrt(i - 2);
                if (baseWhenAddingTwo == Math.round(baseWhenAddingTwo)) {
                    composite = true;
                }
                // check other primes
                for (int j = 0; j < squareBaseBound && !composite; j++) {
                    int rest = i - doubleSquareTable[j];
                    if (rest < 3) {
                        break;
                    }
                    if (primeSieve.isValid(rest)) {
                        composite = true;
                    }
                }
                if (!composite) {
                    result = i;
                }
            }
        }
        System.out.println(result);
        
        Timer.stop();
    }

}
