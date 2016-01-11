package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.PrimeSieve;
import de.darkened.projecteuler.util.Timer;

public class P0003 {

	public static void main(String[] args) {
		Timer.start();

		long number = 600851475143L;

		int result = -1;
		PrimeSieve sieve = new PrimeSieve();
		for (int factor = 2; factor < Integer.MAX_VALUE; factor++) {
			if (sieve.isValid(factor)) {
				while (number % factor == 0) {
					number /= factor;
				}
				if (number == 1) {
					result = factor;
					break;
				}
			}
		}
		if (result > 0 && number == 1) {
			System.out.println(result);
		} else {
			System.out.println("something went wrong" + result);
		}

		Timer.stop();
	}

}
