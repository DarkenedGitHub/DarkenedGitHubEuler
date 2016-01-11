package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.Timer;

public class P0014 {

	public static void main(String[] args) {
		Timer.start();

		int maxStart = 1000000;
		int lengthCacheSize = 1000000;

		int[] lengths = new int[lengthCacheSize];
		int maxLength = 0;
		int result = 0;
		for (int start = 1; start < maxStart; start++) {
			long current = start;
			int length = 0;
			while (current != 1 && (current >= lengthCacheSize || lengths[(int) current] == 0)) {
				if (current % 2 == 0) {
					current = current / 2;
					length++;
				} else {
					current = (3 * current + 1) / 2;
					length += 2;
				}
			}
			if (current == 1) {
				length++;
			} else {
				length = lengths[(int) current] + length;
			}
			if (start < lengthCacheSize) {
				lengths[start] = length;
				// fill doubles
				if (start < lengthCacheSize / 2) {
					int multipleLength = length + 1;
					for (int multiple = start * 2; multiple < lengthCacheSize; multiple *= 2) {
						lengths[multiple] = multipleLength;
						multipleLength++;
					}
				}
			}
			if (length >= maxLength) {
				maxLength = length + 1;
				result = start;
			}
		}
		System.out.println(result);

		Timer.stop();
	}

}
