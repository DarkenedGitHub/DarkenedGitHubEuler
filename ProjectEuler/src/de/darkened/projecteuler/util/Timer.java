package de.darkened.projecteuler.util;

public class Timer {
	
	private static long startTime;
	
	public static void start() {
		startTime = System.currentTimeMillis();
	}
	
	public static void stop() {
		System.out.println("[Timer] " + (System.currentTimeMillis() - startTime) + " ms");
		startTime = System.currentTimeMillis();
	}

}
