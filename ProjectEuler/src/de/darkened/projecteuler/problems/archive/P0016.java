package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.BigDecimalInt;
import de.darkened.projecteuler.util.Timer;

public class P0016 {

	public static void main(String[] args) {
		Timer.start();

		BigDecimalInt x = new BigDecimalInt("1");
		for (int exp = 0; exp < 1000; exp++) {
			x = x.add(x);
		}

		int result = 0;
		for (int digit : x.toDigits()) {
			result += digit;
		}
		System.out.println(result);

		Timer.stop();
	}

}
