package de.darkened.projecteuler.problems.archive;

import java.util.stream.IntStream;

import de.darkened.projecteuler.util.PrimeSieve;
import de.darkened.projecteuler.util.Timer;

public class P0005 {

	public static void main(String[] args) {
		Timer.start();
		int result = -1;
		PrimeSieve sieve = new PrimeSieve();
		int primeProduct = IntStream.range(2, 20).filter(sieve::isValid).reduce(1, (a, b) -> a * b);
		int[] factors = new int[] { 20, 19, 18, 17, 16, 15, 14, 13, 12, 11 };
		for (int i = primeProduct; i < Integer.MAX_VALUE - primeProduct; i += primeProduct) {
			boolean ok = true;
			for (int factor : factors) {
				if (i % factor != 0) {
					ok = false;
					break;
				}
			}
			if (ok) {
				result = i;
				break;
			}
		}
		System.out.println(result);
		Timer.stop();
	}

}
