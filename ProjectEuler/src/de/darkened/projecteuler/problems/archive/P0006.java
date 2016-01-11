package de.darkened.projecteuler.problems.archive;

import java.util.stream.IntStream;

import de.darkened.projecteuler.util.Timer;

public class P0006 {

	public static void main(String[] args) {
		Timer.start();

		int sumOfSquares = IntStream.rangeClosed(1, 100).map(a -> a * a).sum();
		int sum = IntStream.rangeClosed(1, 100).sum();
		int squareOfSum = sum * sum;

		System.out.println(squareOfSum - sumOfSquares);
		Timer.stop();
	}

}
