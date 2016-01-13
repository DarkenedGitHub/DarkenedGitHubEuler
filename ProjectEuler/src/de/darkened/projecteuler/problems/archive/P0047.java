package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.DivisorFinder;
import de.darkened.projecteuler.util.PrimeTable;
import de.darkened.projecteuler.util.Timer;

public class P0047 {
    
    public static void main(String[] args) {
        Timer.start();
        
        int factorCount = 4;
        PrimeTable primeTable = new PrimeTable();
        DivisorFinder divisorFinder = new DivisorFinder(primeTable);
        for (int i = 2; i < Integer.MAX_VALUE - factorCount; i++) {
            boolean match = true;
            for (int offset = 0; offset < factorCount; offset++) {
                if (primeTable.isPrime(i + offset) || divisorFinder.getPrimeFactors(i + offset).length != factorCount) {
                    i += offset;
                    match = false;
                    break;
                }
            }
            if (match) {
                System.out.println(i);
                break;
            }
        }
        
        Timer.stop();
    }

}
