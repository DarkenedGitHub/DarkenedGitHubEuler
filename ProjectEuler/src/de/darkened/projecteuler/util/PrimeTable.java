package de.darkened.projecteuler.util;

import java.util.Arrays;

public class PrimeTable {
	
	private PrimeSieve sieve;
	private int[] primes = new int[] {2, 3};
	
    public PrimeTable(int maxExclusive) {
        sieve = new PrimeSieve(maxExclusive);
        fill(3);
    }

    public PrimeTable() {
		sieve = new PrimeSieve();
		fill(3);
	}
	
	public void fill(int count) {
		int primeIndex = primes.length;
		primes = Arrays.copyOf(primes, count);
		int lastFoundPrime = primes[primeIndex - 1];
		for (int i = lastFoundPrime + 2; primeIndex < count && i < sieve.getMaxValue(); i+=2) {
			if (sieve.isValid(i)) {
				primes[primeIndex++] = i;
			}
		}
		if (primeIndex < primes.length) {
	        primes = Arrays.copyOf(primes, primeIndex);
		}
	}
	
	public int getPrime(int primeIndex) {
		if (primeIndex >= primes.length) {
			fill(primeIndex * 2);
		}
        if (primeIndex >= primes.length) {
            throw new IllegalArgumentException();
        }
		return primes[primeIndex];
	}
	
	public boolean isPrime(int number) {
	    return sieve.isValid(number);
	}

}
