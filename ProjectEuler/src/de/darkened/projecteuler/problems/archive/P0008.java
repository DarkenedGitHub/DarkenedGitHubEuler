package de.darkened.projecteuler.problems.archive;

import java.util.stream.LongStream;

import de.darkened.projecteuler.util.DataLoader;
import de.darkened.projecteuler.util.Timer;

public class P0008 {
	
	public static void main(String[] args) {
		int[] digits = DataLoader.getDigits(P0008.class.getSimpleName());
		Timer.start();

		int factorCount = 13;
		long maxProduct = 0;
		long product = 0;
		int startIndex = 0;
		int nextZeroIndex = -1;
		while (nextZeroIndex < digits.length) {
			for (int i = startIndex; i < nextZeroIndex - factorCount; i++) {
				if (product != 0) {
					product = product / digits[i] * digits[i + factorCount];
				} else {
					product = getProduct(digits, i + 1, factorCount);
				}
				if (product > maxProduct) {
					maxProduct = product;
				}
			}
			startIndex = nextZeroIndex;
			nextZeroIndex = findNextZeroIndex(digits, startIndex + 1);
			product = 0;
		}
		System.out.println(maxProduct);
		
		Timer.stop();
	}
	
	private static int findNextZeroIndex(int[] digits, int startIndex) {
		int nextZeroIndex = startIndex;
		while (nextZeroIndex < digits.length && digits[nextZeroIndex] != 0) {
			nextZeroIndex++;
		}
		return nextZeroIndex;
	}
	
	private static long getProduct(int[] digits, int startIndex, int factorCount) {
		return LongStream.range(startIndex, startIndex + factorCount).
				map(index -> digits[(int) index]).
				reduce(1, (a, b) -> a * b);
	}

}
