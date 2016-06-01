package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.DivisorFinder;
import de.darkened.projecteuler.util.PrimeTable;
import de.darkened.projecteuler.util.Timer;

public class P0243 {
    
    static PrimeTable table = new PrimeTable(100);
    static DivisorFinder divisorFinder = new DivisorFinder(table);

    public static void main(String[] args) {
        Timer.start();

        double bound = 15499d/94744d;
        System.out.println(bound);
        
        for (int factorCount = 1; factorCount <= 9; factorCount++) {
            boolean foundResult = false;
            double lastFound = 1d;
            int denominatorBase = denominator(factorCount);
            for (int multiplier = 1; multiplier < table.getPrime(factorCount); multiplier++) {
                int denominator = denominatorBase * multiplier;
                System.out.print(denominatorBase + "*" + multiplier + "= " + denominator + " : ");
                double resilience = usingPhi(denominator, factorCount);
                System.out.println(resilience);
                if (resilience < bound) {
                    foundResult = true;
                    break;
                } else if ((lastFound - resilience) * (table.getPrime(factorCount) - multiplier) < resilience - bound) {
                    break;
                }
                lastFound = resilience;
            }
            if (foundResult) {
                break;
            }
        }
        
        Timer.stop();
    }
    
    // slow solution
//    private static double resilience(int denominator, int factorCount) {
//        int resilient = 1;
//        for (int numerator = 2; numerator < denominator; numerator++) {
//            boolean isResilient = true;
//            for (int factorIndex = 0; factorIndex < factorCount; factorIndex++) {
//                if (numerator % table.getPrime(factorIndex) == 0) {
//                    isResilient = false;
//                    break;
//                }
//            }
//            if (isResilient) {
//                resilient++;
//            }
//        }
//        return resilient / (denominator - 1d);
//    }
    
    // euler totient function
    private static double usingPhi(int denominator, int factorCount) {
        double resilience = 1;
        for (int primeFactor : divisorFinder.getPrimeFactors(denominator)) {
            resilience *= 1d - 1d / (double) primeFactor;
        }
        
        return (resilience * denominator) / (denominator - 1d);
    }
    
    private static int denominator(int factorCount) {
        int denominator = 1;
        for (int factorIndex = 0; factorIndex < factorCount; factorIndex++) {
            denominator *= table.getPrime(factorIndex);
        }
        return denominator;
    }

}
