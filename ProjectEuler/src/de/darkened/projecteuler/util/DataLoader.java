package de.darkened.projecteuler.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataLoader {
	
	public static int[] getNumberGridSerial(String problemID) {
		return getDataLines(problemID).flatMapToInt(
				line -> Arrays.stream(line.split(" ")).mapToInt(Integer::valueOf)).toArray();
	}
	
	public static int[][] getNumberTriangle(String problemID) {
		// read as sequence and convert back to triangle form 
		int[] numbers = getNumberGridSerial(problemID);
		int rowCount = (int) (Math.sqrt(2 * numbers.length + 0.25) - 0.5);
		int[][] triangle = new int[rowCount][];
		int numberIndex = 0;
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			triangle[rowIndex] = new int[rowIndex + 1];
			for (int columnIndex = 0; columnIndex <= rowIndex; columnIndex++) {
				triangle[rowIndex][columnIndex] = numbers[numberIndex++];
			}
		}
		return triangle;
	}
	
	public static int[] getDigits(String problemID) {
		return getDataString(problemID).chars().map(c -> c - 48).toArray();
	}
	
	public static String[] getStrings(String problemID) {
		return getDataString(problemID).replace("\"", "").split(",");
	}
	
	public static List<BigDecimalInt> getBigNumbers(String problemID) {
		return getDataLines(problemID).map(BigDecimalInt::new).collect(Collectors.toList());
	}
	
	private static String getDataString(String problemID) {
		return getDataLines(problemID).reduce("", String::concat);
	}
	
	private static Stream<String> getDataLines(String problemID) {
		String fileName = "/data/" + problemID + ".data";
		try {
			return Files.lines(Paths.get(DataLoader.class.getResource(fileName).toURI()));
		} catch (IOException | URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
	
}
