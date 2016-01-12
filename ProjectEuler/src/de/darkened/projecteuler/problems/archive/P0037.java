package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.PrimeTable;
import de.darkened.projecteuler.util.Timer;

public class P0037 {
    
    public static void main(String[] args) {
        Timer.start();
        
        PrimeTable table = new PrimeTable();
        
        int sum = 0;
        int count = 0;
        for (int primeIndex = 0; count < 11; primeIndex++) {
            int prime = table.getPrime(primeIndex);
            if (prime < 10) {
                continue;
            }
            boolean truncatable = true;
            for (int truncatedRight = prime / 10; truncatedRight > 0 && truncatable; truncatedRight /= 10) {
                if (!table.isPrime(truncatedRight)) {
                    truncatable = false;
                }
            }
            int pow10 = 10;
            for (int truncatedLeft = prime % pow10; truncatedLeft < prime && truncatable; truncatedLeft = prime % pow10) {
                if (!table.isPrime(truncatedLeft)) {
                    truncatable = false;
                }
                pow10 *= 10;
            }
            if (truncatable) {
                sum += prime;
                count++;
            }
        }
        System.out.println(sum);
        
        Timer.stop();
    }

}
