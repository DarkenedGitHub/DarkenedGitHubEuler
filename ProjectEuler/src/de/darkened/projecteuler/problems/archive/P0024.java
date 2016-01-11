package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.Timer;

public class P0024 {

	public static void main(String[] args) {
		Timer.start();

		int elementCount = 10;
		int permutationIndex = 1000000;
		boolean[] usedDigits = new boolean[elementCount];
		for (int i = 0; i < elementCount; i++) {
			int faculty = faculty(elementCount - i - 1);
			int digitPos = (permutationIndex - 1) / faculty;
			permutationIndex = (permutationIndex - 1) % faculty + 1;
			for (int j = 0; digitPos >= 0; j++) {
				if (!usedDigits[j]) {
					digitPos--;
				}
				if (digitPos == -1) {
					usedDigits[j] = true;
					System.out.print(j);
				}
			}
		}

		System.out.println();
		Timer.stop();
	}

	private static int faculty(int x) {
		return x == 0 ? 1 : x * faculty(x - 1);
	}

}
