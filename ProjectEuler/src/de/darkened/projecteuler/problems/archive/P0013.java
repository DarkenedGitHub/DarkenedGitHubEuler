package de.darkened.projecteuler.problems.archive;

import java.util.List;

import de.darkened.projecteuler.util.BigDecimalInt;
import de.darkened.projecteuler.util.DataLoader;
import de.darkened.projecteuler.util.Timer;

public class P0013 {

	public static void main(String[] args) {
		List<BigDecimalInt> numbers = DataLoader.getBigNumbers(P0013.class.getSimpleName());
		Timer.start();

		BigDecimalInt sum = numbers.stream().reduce(BigDecimalInt::add).orElse(new BigDecimalInt("0"));
		String firstTenDigits = sum.toString().replace("_", "").substring(0, 10);
		System.out.println(firstTenDigits);

		Timer.stop();
	}

}
