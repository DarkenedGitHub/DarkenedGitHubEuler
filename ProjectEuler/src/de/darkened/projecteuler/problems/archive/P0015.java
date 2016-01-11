package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.Timer;

public class P0015 {

	public static void main(String[] args) {
		Timer.start();

		int size = 20;
		long[][] square = new long[size + 1][size + 1];
		for (int x = 0; x <= size; x++) {
			for (int y = 0; y <= size; y++) {
				square[x][y] = x == 0 || y == 0 ? 1 : square[x - 1][y] + square[x][y - 1];
			}
		}
		System.out.println(square[size][size]);

		Timer.stop();
	}

}
