package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.PrimeSieve;
import de.darkened.projecteuler.util.Timer;

public class P0010 {
	
	public static void main(String[] args) {
		Timer.start();
		
		int bound = 2000000;
		PrimeSieve sieve = new PrimeSieve(bound);
		sieve.fill();
		long sum = 0;
		for (int i = 1; i < bound; i++) {
			if (sieve.isValid(i)) {
				sum += i;
			}
		}
		System.out.println(sum);
		
		Timer.stop();
	}

}
