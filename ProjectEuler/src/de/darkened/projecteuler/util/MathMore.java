package de.darkened.projecteuler.util;

public class MathMore {

	private static int[] pow2;

	static {
		pow2 = new int[(int) Math.floor(Math.log(Integer.MAX_VALUE) / Math.log(2))];
		int currentPow2 = 1;
		for (int i = 0; i < pow2.length; i++) {
			pow2[i] = currentPow2;
			currentPow2 *= 2;
		}
	}

	public static int pow2(int exp) {
		return pow2[exp];
	}

	public static int floorLog2(int x) {
		int result = 0;
		for (int i = 0; i < pow2.length && x > pow2[i]; i++) {
			result = i;
		}
		return result;
	}

	public static int gcd(int a, int b) {
		if (a > b) {
			int c = b;
			b = a;
			a = c;
		}
		while (b % a != 0) {
			int c = b % a;
			b = a;
			a = c;
		}
		return a;
	}

}
