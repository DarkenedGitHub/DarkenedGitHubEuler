package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.AbundantSieve;
import de.darkened.projecteuler.util.Timer;

public class P0023 {

	public static void main(String[] args) {
		Timer.start();

		int bound = 28123;
		AbundantSieve sieve = new AbundantSieve(bound + 1);
		sieve.fill();
		int[] abundantNumbers = new int[bound];
		int abundantNumberCount = 0;
		for (int number = 1; number <= bound; number++) {
			if (sieve.isValid(number)) {
				abundantNumbers[abundantNumberCount++] = number;
			}
		}

		boolean[] canBeSum = new boolean[bound];
		for (int summandIndex1 = 0; summandIndex1 < abundantNumberCount; summandIndex1++) {
			if (abundantNumbers[summandIndex1] > bound / 2) {
				break;
			}
			for (int summandIndex2 = summandIndex1; summandIndex2 < abundantNumberCount; summandIndex2++) {
				int sum = abundantNumbers[summandIndex1] + abundantNumbers[summandIndex2];
				if (sum <= bound) {
					canBeSum[sum - 1] = true;
				}
			}
		}

		int total = 0;
		for (int i = 1; i <= bound; i++) {
			if (!canBeSum[i - 1]) {
				total += i;
			}
		}

		System.out.println(total);

		Timer.stop();
	}

}
