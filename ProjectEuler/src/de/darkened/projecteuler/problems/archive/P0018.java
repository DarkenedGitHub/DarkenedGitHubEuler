package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.DataLoader;
import de.darkened.projecteuler.util.Timer;

public class P0018 {

	public static void main(String[] args) {
		int[][] triangle = DataLoader.getNumberTriangle(P0018.class.getSimpleName());
		Timer.start();

		// sum bottom up (starting at second line from bottom)
		for (int rowIndex = triangle.length - 2; rowIndex >= 0; rowIndex--) {
			for (int columnIndex = 0; columnIndex <= rowIndex; columnIndex++) {
				int firstChild = triangle[rowIndex + 1][columnIndex];
				int secondChild = triangle[rowIndex + 1][columnIndex + 1];
				triangle[rowIndex][columnIndex] += Math.max(firstChild, secondChild);
			}
		}
		System.out.println(triangle[0][0]);

		Timer.stop();
	}

}
