package de.darkened.projecteuler.problems;

import java.util.Arrays;

import de.darkened.projecteuler.util.Digits;
import de.darkened.projecteuler.util.Timer;

public class P0043 {
    
    public static void main(String[] args) {
        Timer.start();
        
        // 1406357289
        // 2  | 406
        // 3  | 063
        // 5  | 635
        // 7  | 357
        // 11 | 572
        // 13 | 728
        // 17 | 289

        int[] primes = new int[] { 13, 11, 7, 5, 3, 2 };
        // 17
        int[] incompleteNumbers = new int[999 / 17];
        for (int factor = 1; factor <= incompleteNumbers.length; factor++) {
            incompleteNumbers[factor - 1] = 17 * factor;
        }
        int pow10 = 10;
        for (int primeIndex = 0; primeIndex < primes.length; primeIndex++) {
            int[] generatedNumbers = new int[incompleteNumbers.length * 10];
            int count = 0;
            for (int incomplete : incompleteNumbers) {
                int lastDigits = incomplete / pow10;
                for (int nextDigit = 0; nextDigit <= 9; nextDigit++) {
                    int threeDigits = nextDigit * 100 + lastDigits;
                    if (threeDigits % primes[primeIndex] == 0) {
                        generatedNumbers[count++] = nextDigit * pow10 * 100 + incomplete;
                    }
                }
            }
            incompleteNumbers = Arrays.copyOf(generatedNumbers, count);
            pow10 *= 10;
        }
        // add missing digit and sum up if pandigital
        long sum = 0;
        for (int incomplete : incompleteNumbers) {
            for (int nextDigit = 1; nextDigit <= 9; nextDigit++) {
                long complete = nextDigit * 1000000000L + incomplete;
                if (Digits.isNDigitPandigital(complete, true)) {
                    sum += complete;
                }
            }
        }
        System.out.println(sum);
        
        Timer.stop();
    }

}
