package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.Timer;

public class P0019 {

	public static void main(String[] args) {
		Timer.start();

		int weekday = 1; // 1.1.1900

		int count = 0;
		for (int year = 1900; year <= 2000; year++) {
			boolean leap = year % 4 == 0;
			for (int month = 1; month <= 12; month++) {
				if (year > 1900 && weekday == 0) {
					count++;
				}
				int shift = 3;
				switch (month) {
				case 2:
					shift = leap ? 1 : 0;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					shift = 2;
				}
				weekday = (weekday + shift) % 7;
			}
		}

		System.out.println(count);
		Timer.stop();
	}

}
