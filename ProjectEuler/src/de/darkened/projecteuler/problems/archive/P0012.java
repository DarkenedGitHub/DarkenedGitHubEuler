package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.PrimeTable;
import de.darkened.projecteuler.util.Timer;

public class P0012 {

	public static void main(String[] args) {
		Timer.start();

		PrimeTable table = new PrimeTable();
		int triangle = 1;
		int result = 0;
		for (int summand = 2; triangle <= 76576500; summand++) {
			triangle += summand;
			if (check500Divisors(table, triangle)) {
				result = triangle;
				break;
			}
		}

		System.out.println(result);
		Timer.stop();
	}

	private static boolean check500Divisors(PrimeTable table, int number) {
		int rest = number;
		int count = 1;
		for (int primeIndex = 0; rest > 1; primeIndex++) {
			int currentPrime = table.getPrime(primeIndex);
			if (rest % currentPrime == 0) {
				int countOfCurrentFactor = 0;
				while (rest % currentPrime == 0) {
					countOfCurrentFactor++;
					rest /= currentPrime;
				}
				count *= countOfCurrentFactor + 1;
			}
		}

		return count > 500;
	}

}
