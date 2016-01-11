package de.darkened.projecteuler.problems;

import java.util.Arrays;

import de.darkened.projecteuler.util.PrimeTable;
import de.darkened.projecteuler.util.Timer;

public class P0041 {
    
    public static void main(String[] args) {
        Timer.start();
        
        PrimeTable table = new PrimeTable();
        int result = 0;
        // pandigital numbers with 8 or 9 digits are always divisible by 3
        for (int digitCount = 7; digitCount > 0 && result == 0; digitCount--) {
            int[] nDigitPermutations = createPermutations(digitCount);
            Arrays.sort(nDigitPermutations);
            for (int permutationIndex = nDigitPermutations.length - 1; permutationIndex >= 0; permutationIndex--) {
                if (isPrime(nDigitPermutations[permutationIndex], table)) {
                    result = nDigitPermutations[permutationIndex];
                    break;
                }
            }
        }
        System.out.println(result);
        
        Timer.stop();
    }
    
    private static int[] createPermutations(int digitCount) {
        if (digitCount == 1) {
            return new int[] { 1 };
        }
        int[] lowerOrderPermutations = createPermutations(digitCount - 1);
        int[] permutations = new int[lowerOrderPermutations.length * digitCount];
        int permutationIndex = 0;
        int insertPosPower = 1;
        for (int insertPos = 0; insertPos < digitCount; insertPos++) {
            for (int lowerOrderPermutation : lowerOrderPermutations) {
                int upper = lowerOrderPermutation / insertPosPower;
                int lower = lowerOrderPermutation % insertPosPower;
                permutations[permutationIndex++] = (upper * 10 + digitCount) * insertPosPower + lower; 
            }
            insertPosPower *= 10;
        }
        return permutations;
    }
    
    private static boolean isPrime(int number, PrimeTable table) {
        int sqrt = (int) Math.sqrt(number);
        for (int primeIndex = 0; table.getPrime(primeIndex) <= sqrt; primeIndex++) {
            if (number % table.getPrime(primeIndex) == 0) {
                return false;
            }
        }
        return true;
    }

}
