package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.PrimeSieve;
import de.darkened.projecteuler.util.Timer;

public class P0007 {

	public static void main(String[] args) {
		Timer.start();

		PrimeSieve sieve = new PrimeSieve();
		int number = 1;
		int foundPrimes = 0;
		while (foundPrimes < 10001) {
			number++;
			if (sieve.isValid(number)) {
				foundPrimes++;
			}
		}
		System.out.println(number);

		Timer.stop();
	}

}
