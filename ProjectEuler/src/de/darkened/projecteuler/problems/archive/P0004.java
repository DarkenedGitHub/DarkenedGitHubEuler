package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.Timer;

public class P0004 {

	public static void main(String[] args) {
		Timer.start();
		int result = -1;

		for (int possiblePali = 999999; possiblePali > 0 && result < 0; possiblePali--) {
			if (!isPalindrome(possiblePali)) {
				continue;
			}
			for (int factor = 999; factor >= 100; factor--) {
				if (possiblePali % factor == 0) {
					int otherFactor = possiblePali / factor;
					if (otherFactor >= 100 && otherFactor < 1000) {
						result = possiblePali;
						break;
					}
				}
			}
		}

		System.out.println(result);
		Timer.stop();
	}

	private static boolean isPalindrome(int x) {
		int[] digits = new int[10];
		int digitIndex = 0;
		while (x > 0) {
			digits[digitIndex] = x % 10;
			x /= 10;
			digitIndex++;
		}
		int length = digitIndex;
		for (digitIndex = 0; digitIndex < length / 2; digitIndex++) {
			if (digits[digitIndex] != digits[length - 1 - digitIndex]) {
				return false;
			}
		}
		return true;
	}

}
