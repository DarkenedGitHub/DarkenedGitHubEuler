package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.Timer;

public class P0028 {

	public static void main(String[] args) {
		Timer.start();

		int size = 1001;
		int sum = 1;
		int square = 1;
		for (int i = 3; i <= size; i += 2) {
			int length = i - 1; // length of a side
			int nextSquare = square + 4 * length; // start for next turn, top-right corner
			sum += 4 * square + 10 * length; // start for this turn + 4,3,2,1 sides
			square = nextSquare;
		}
		System.out.println(sum);

		Timer.stop();
	}

}
