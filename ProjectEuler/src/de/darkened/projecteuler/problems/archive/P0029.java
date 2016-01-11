package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.Timer;

public class P0029 {

	public static void main(String[] args) {
		Timer.start();

		int start = 2;
		int end = 100;

		int[][] powers = new int[][] { { 4, 2 }, { 9, 2 }, { 16, 2 }, { 25, 2 }, { 36, 2 }, { 49, 2 }, { 64, 2 },
		        { 81, 2 }, { 100, 2 }, { 8, 3 }, { 27, 3 }, { 64, 3 }, { 16, 4 }, { 81, 4 }, { 32, 5 }, { 64, 6 }, };

		int duplicateCount = 0;
		for (int a = start; a <= end; a++) {
			for (int b = start; b <= end; b++) {
				for (int[] powerAndExp : powers) {
					if (a == powerAndExp[0]) {
						if (isDuplicate(b, powerAndExp[1], end)) {
							duplicateCount++;
							break;
						}
					}
				}
			}
		}
		int result = (end - start + 1) * (end - start + 1) - duplicateCount;
		System.out.println(result);

		Timer.stop();
	}

	// a = x^y
	// (x^y)^b = (x^(y-q))^z ; q < y
	// x^(by) = x^(z(y-q))
	// by = z(y-q)
	// z = by/(y-q) ; z <= end ; z is an integer
	private static boolean isDuplicate(int b, int y, int max) {
		for (int q = 1; q < y; q++) {
			int z = (b * y) / (y - q);
			boolean isInteger = (b * y) % (y - q) == 0;
			if (z <= max && isInteger) {
				return true;
			}
		}
		return false;
	}

}
