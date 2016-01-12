package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.PrimeTable;
import de.darkened.projecteuler.util.Timer;

public class P0035 {
    
    public static void main(String[] args) {
        Timer.start();
        
        int bound = 1000000;
        PrimeTable table = new PrimeTable(bound * 2);
        int count = 0;
        for (int primeIndex = 0; table.getPrime(primeIndex) < bound; primeIndex++) {
            int prime = table.getPrime(primeIndex);
            int highDigitBase = 1;
            for (int rest = prime; rest > 0; rest /= 10) {
                highDigitBase *= 10;
            }
            boolean isCircularPrime = true;
            while (table.getPrime(primeIndex) != (prime = ((prime % 10) * highDigitBase + prime) / 10)) {
                if (!table.isPrime(prime)) {
                    isCircularPrime = false;
                    break;
                }
            }
            if (isCircularPrime) {
                count++;
            }
        }
        System.out.println(count);
        
        Timer.stop();
    }

}
