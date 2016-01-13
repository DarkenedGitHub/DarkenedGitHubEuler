package de.darkened.projecteuler.util;

import java.util.Arrays;

public class DivisorFinder {
	
	private PrimeTable primeTable;
	
	public DivisorFinder(PrimeTable _primeTable) {
	    primeTable = _primeTable;
	}
	
	public DivisorFinder() {
	    this(new PrimeTable());
	}
	
	public int getDivisorSum(int number) {
		int sum = 0;
		for (int divisor : getDivisors(number)) {
			sum += divisor;
		};
		return sum - number;
	}
	
	/** leaving out 1 and number */
	public int[] getRealDivisors(int number) {
	    int[] divisors = getDivisors(number);
	    return Arrays.copyOfRange(divisors, 1, divisors.length - 1);
	}
	
	private int[] getDivisors(int number) {
        int[][] primeFactorsAndCounts = getPrimeFactorsWithCounts(number);
        return getDivisors(primeFactorsAndCounts, 0);
	}
	
	private int[] getDivisors(int[][] primeFactorsAndCounts, int startIndex) {
		if (startIndex == primeFactorsAndCounts[0].length) {
			return new int[] { 1 };
		} else {
			int[] divisors = getDivisors(primeFactorsAndCounts, startIndex + 1);
			int currentFactor = primeFactorsAndCounts[0][startIndex];
			int currentCount = primeFactorsAndCounts[1][startIndex];
			int[] expandedDivisors = new int[divisors.length * (currentCount + 1)];
			for (int divisorIndex = 0; divisorIndex < divisors.length; divisorIndex++) {
				int divisorFactor = 1;
				for (int multiplier = 0; multiplier <= currentCount; multiplier++) {
					expandedDivisors[divisorIndex * (currentCount + 1) + multiplier] = divisors[divisorIndex] * divisorFactor;
					divisorFactor *= currentFactor;
				}
			}
			return expandedDivisors;
		}
	}

	public int[] getPrimeFactorsWithDuplicates(int x) {
		int[][] primeFactorsAndCounts = getPrimeFactorsWithCounts(x);
		int overallCount = 0;
		for (int count : primeFactorsAndCounts[1]) {
			overallCount += count;
		}
		int[] result = new int[overallCount];
		int resultIndex = 0;
		for (int factorIndex = 0; factorIndex < primeFactorsAndCounts[0].length; factorIndex++) {
			for (int duplicateIndex = 0; duplicateIndex < primeFactorsAndCounts[1][factorIndex]; duplicateIndex++) {
				result[resultIndex++] = primeFactorsAndCounts[0][factorIndex];
			}
		}
		return result;
	}
	
	public int[] getPrimeFactors(int x) {
	    return getPrimeFactorsWithCounts(x)[0];
	}

	private int[][] getPrimeFactorsWithCounts(int x) {
		int rest = x;
		int[] primeFactors = new int[Math.max(1, MathMore.floorLog2(x))];
		int[] factorCounts = new int[primeFactors.length];
		int factorIndex = 0;
		for (int primeIndex = 0; primeTable.getPrime(primeIndex) <= rest / 2; primeIndex++) {
			int currentPrime = primeTable.getPrime(primeIndex);
			int currentFactorCount = 0;
			while(rest % currentPrime == 0) {
				currentFactorCount++;
				rest /= currentPrime;
			}
			if (currentFactorCount > 0) {
				primeFactors[factorIndex] = currentPrime;
				factorCounts[factorIndex] = currentFactorCount;
				factorIndex++;
			}
		}
		if (rest > 1) {
			primeFactors[factorIndex] = rest;
			factorCounts[factorIndex] = 1;
			factorIndex++;
		}
		primeFactors = Arrays.copyOf(primeFactors, factorIndex);
		factorCounts = Arrays.copyOf(factorCounts, factorIndex);
		return new int[][] { primeFactors, factorCounts };
	}

}
