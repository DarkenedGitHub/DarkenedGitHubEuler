package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.PrimeSieve;
import de.darkened.projecteuler.util.Timer;

public class P0027 {

	public static void main(String[] args) {
		Timer.start();

		PrimeSieve sieve = new PrimeSieve();

		int bound = 1000;
		int coefficientRange = (2 * (bound - 1) + 1);
		int[][] generators = new int[coefficientRange * coefficientRange][];
		for (int aIndex = 0; aIndex < coefficientRange; aIndex++) {
			for (int bIndex = 0; bIndex < coefficientRange; bIndex++) {
				generators[aIndex * coefficientRange + bIndex] = new int[] { aIndex - bound + 1, bIndex - bound + 1 };
			}
		}

		int n = 0;
		while (generators.length > 1) {
			int invalidGenerators = 0;
			for (int generatorIndex = 0; generatorIndex < generators.length; generatorIndex++) {
				int a = generators[generatorIndex][0];
				int b = generators[generatorIndex][1];
				int possiblePrime = (n + a) * n + b;
				if (possiblePrime < 2 || !sieve.isValid(possiblePrime)) {
					generators[generatorIndex] = null;
					invalidGenerators++;
				}
			}
			int[][] reducedGenerators = new int[generators.length - invalidGenerators][];
			int reducedGeneratorIndex = 0;
			for (int[] generator : generators) {
				if (generator != null) {
					reducedGenerators[reducedGeneratorIndex++] = generator;
				}
			}
			generators = reducedGenerators;
			n++;
		}
		if (generators.length == 1) {
			System.out.println(generators[0][0] * generators[0][1]);
		} else {
			System.out.println("no single generator found");
		}

		Timer.stop();
	}

}
