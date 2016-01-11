package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.Timer;

public class P0002 {

	public static void main(String[] args) {
		Timer.start();

		int first = 1;
		int second = 2;
		int result = 0;
		while (second < 4000000) {
			if (second % 2 == 0) {
				result += second;
			}

			int next = first + second;
			first = second;
			second = next;
		}

		System.out.println(result);
		Timer.stop();
	}

}
