package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.Timer;

public class P0009 {
	
	public static void main(String[] args) {
		Timer.start();
		
		int result = -1;
		for (int a = 1; a <= 1000; a++) {
			int a2 = a * a;
			for (int b = a + 1; b <= 1000 - a; b++) {
				int b2 = b * b;
				int ab2 = a2 + b2;
				int apb = a + b;
				for (int c = b + 1; c <= 1000 - apb; c++) {
					int c2 = c * c;
					if (c2 > ab2) break;
					if (c + apb == 1000 && c2 == ab2) {
						result = a * b * c;
						a = b = c = 1001; // end all loops
					}
				}
			}
		}
		System.out.println(result);
		
		Timer.stop();
	}

}
