package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.BigDecimalInt;
import de.darkened.projecteuler.util.Timer;

public class P0025 {

	public static void main(String[] args) {
		Timer.start();

		BigDecimalInt a = new BigDecimalInt(1);
		BigDecimalInt b = new BigDecimalInt(1);
		int index = 2;
		while (b.getDigitCount() < 1000) {
			BigDecimalInt next = a.add(b);
			a = b;
			b = next;
			index++;
		}
		System.out.println(index);

		Timer.stop();
	}

}
