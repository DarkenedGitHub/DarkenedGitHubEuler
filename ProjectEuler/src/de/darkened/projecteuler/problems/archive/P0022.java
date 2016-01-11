package de.darkened.projecteuler.problems.archive;

import java.util.Arrays;

import de.darkened.projecteuler.util.DataLoader;
import de.darkened.projecteuler.util.Timer;

public class P0022 {

	public static void main(String[] args) {
		String[] names = DataLoader.getStrings(P0022.class.getSimpleName());
		Timer.start();

		Arrays.sort(names);
		int sum = 0;
		for (int i = 0; i < names.length; i++) {
			int value = 0;
			for (char c : names[i].toCharArray()) {
				value += c - 'A' + 1;
			}
			sum += value * (i + 1);
		}
		System.out.println(sum);

		Timer.stop();
	}

}
