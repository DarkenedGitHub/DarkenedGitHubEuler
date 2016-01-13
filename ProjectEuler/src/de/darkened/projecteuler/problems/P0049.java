package de.darkened.projecteuler.problems;

import java.util.Arrays;

import de.darkened.projecteuler.util.PrimeTable;
import de.darkened.projecteuler.util.Timer;

public class P0049 {
    
    public static void main(String[] args) {
        Timer.start();
        
        PrimeTable primeTable = new PrimeTable();
        for (int primeIndex1 = 0; primeTable.getPrime(primeIndex1) < 10000; primeIndex1++) {
            int prime1 = primeTable.getPrime(primeIndex1);
            if (prime1 < 1000) {
                continue;
            }
            for (int primeIndex2 = primeIndex1 + 1; primeTable.getPrime(primeIndex2) < 10000; primeIndex2++) {
                int prime2 = primeTable.getPrime(primeIndex2);
                int prime3 = prime2 + prime2 - prime1;
                if (prime3 > 10000) {
                    break;
                }
                if (primeTable.isPrime(prime3)) {
                    int prime1Ordered = orderedDigits(prime1);
                    if (prime1Ordered == orderedDigits(prime2) && prime1Ordered == orderedDigits(prime3)) {
                        orderedDigits(prime1);
                        orderedDigits(prime2);
                        orderedDigits(prime3);
                        System.out.println(prime1 + "" + prime2 + "" + prime3);
                    }
                }
            }
        }
        
        Timer.stop();
    }
    
    private static int orderedDigits(int unordered) {
        int[] digits = new int[4];
        int digitIndex = 0;
        while (unordered > 0) {
            digits[digitIndex++] = unordered % 10;
            unordered /= 10;
        }
        Arrays.sort(digits);
        int ordered = 0;
        while (digitIndex > 0) {
            ordered = ordered * 10 + digits[--digitIndex];
        }
        return ordered;
    }

}
