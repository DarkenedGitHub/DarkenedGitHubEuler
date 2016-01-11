package de.darkened.projecteuler.problems.archive;

import java.util.stream.IntStream;

import de.darkened.projecteuler.util.Timer;

public class P0001 {

	public static void main(String[] args) {
		Timer.start();
		int result = IntStream.range(1, 1000).filter(x -> x % 3 == 0 || x % 5 == 0).sum();
		System.out.println(result);
		Timer.stop();
	}

}
