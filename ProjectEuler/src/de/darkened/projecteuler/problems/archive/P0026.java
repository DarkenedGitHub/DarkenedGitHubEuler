package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.Timer;

public class P0026 {

	public static void main(String[] args) {
		Timer.start();

		int maxCycleLength = 0;
		int resultD = 0;
		for (int d = 1; d < 1000; d++) {
			int rest = 1;
			int[] cyclesForRest = new int[d + 1];
			int cycle = 0;
			while (rest > 0 && cyclesForRest[rest] == 0) {
				cyclesForRest[rest] = ++cycle;
				rest = (rest * 10) % d;
			}
			int recurringCycleLength = cycle - cyclesForRest[rest] + 1;
			if (rest > 0 && recurringCycleLength > maxCycleLength) {
				maxCycleLength = recurringCycleLength;
				resultD = d;
			}
		}
		System.out.println(resultD);

		Timer.stop();
	}

}
