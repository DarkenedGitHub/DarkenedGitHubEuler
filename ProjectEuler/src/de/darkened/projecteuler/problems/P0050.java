package de.darkened.projecteuler.problems;

import de.darkened.projecteuler.util.PrimeTable;
import de.darkened.projecteuler.util.Timer;

public class P0050 {
    
    public static void main(String[] args) {
        Timer.start();
        
        int bound = 1000000;
        PrimeTable primeTable = new PrimeTable(bound * 11 / 10);
        Timer.stop();
        
        int bestMatch = 41;
        int maxChainLength = 6;
        int nextStartChainLength = 7;
        for (int primeIndex = 1; primeTable.getPrime(primeIndex) * nextStartChainLength < bound; primeIndex++) {
            // setup minimal chain
            int sum = 0;
            for (int offset = 0; offset <= nextStartChainLength; offset++) {
                sum += primeTable.getPrime(primeIndex + offset);
            }
            int offset = nextStartChainLength;
            while (sum < bound) {
                if (primeTable.isPrime(sum)) {
                    bestMatch = sum;
                    maxChainLength = offset;
                }
                sum += primeTable.getPrime(primeIndex + offset + 1);
                sum += primeTable.getPrime(primeIndex + offset + 2);
                offset += 2;
            }
            nextStartChainLength = maxChainLength + 2;
        }
        System.out.println(bestMatch);
        
        Timer.stop();
    }

}
