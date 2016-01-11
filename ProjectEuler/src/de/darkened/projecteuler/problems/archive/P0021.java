package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.DivisorFinder;
import de.darkened.projecteuler.util.Timer;

public class P0021 {

	public static void main(String[] args) {
		Timer.start();

		int bound = 10000;
		DivisorFinder divisorFinder = new DivisorFinder();

		int numberSum = 0;
		for (int number = 1; number < bound; number++) {
			int factorSum = divisorFinder.getDivisorSum(number);
			if (factorSum > number && divisorFinder.getDivisorSum(factorSum) == number) {
				numberSum = numberSum + number + factorSum;
			}
		}
		System.out.println(numberSum);

		Timer.stop();
	}

}
