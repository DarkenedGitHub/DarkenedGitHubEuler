package de.darkened.projecteuler.util;

import java.util.Arrays;

public class PrimeTable {
	
	private PrimeSieve sieve;
	private int[] primes = new int[] {2, 3};
	
	public PrimeTable() {
		sieve = new PrimeSieve();
		fill(3);
	}
	
	public void fill(int count) {
		int primeIndex = primes.length;
		primes = Arrays.copyOf(primes, count);
		int lastFoundPrime = primes[primeIndex - 1];
		for (int i = lastFoundPrime + 2; primeIndex < count; i+=2) {
			if (sieve.isValid(i)) {
				primes[primeIndex++] = i;
			}
		}
	}
	
	public int getPrime(int primeIndex) {
		if (primeIndex >= primes.length) {
			fill(primeIndex * 2);
		}
		return primes[primeIndex];
	}

}
