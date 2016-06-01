package de.darkened.projecteuler.problems.unresolved;

import de.darkened.projecteuler.util.PrimeTable;
import de.darkened.projecteuler.util.Timer;

public class P0543 {
    
    private static PrimeTable primeTable = new PrimeTable();
    
    public static void main(String[] args) {
        Timer.start();
        
        System.out.println(s(1000));
        
        
        Timer.stop();
    }
    
    private static int s(int max) {
        int sum = 0;
        for (int i = 2; i <= max; i++) {
            for (int k = 1; k <= i / 2; k++) {
                if (p(i, k)) {
                    sum++;
                }
            }
        }
        return sum;
    }
    
    private static boolean p(int number, int factorCount) {
        if (factorCount == 1) {
            return primeTable.isPrime(number);
        } else {
            for (int prime : primeTable) {
                if (prime > number - 2) {
                    break;
                }
                if (p(number - prime, factorCount - 1)) {
                    return true;
                }
            }
            return false;
        }
    }

}
