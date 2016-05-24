package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.DataLoader;
import de.darkened.projecteuler.util.Timer;

public class P0011 {
	
	public static void main(String[] args) {
		int[] grid = DataLoader.getNumberGridSerial(P0011.class.getSimpleName(), " ");
		Timer.start();
		
		int gridSize = 20;
		assert grid.length == gridSize * gridSize;
		int sequenceLength = 4;
		int maxProduct = 0;
		int gridEnd = gridSize * gridSize;
		for (int i = 0; i < gridSize; i++) {
			int[][] lines = new int[6][];
			
			lines[0] = createLine(grid, i * gridSize    , (i + 1) * gridSize    , 1);            // horizontal
			lines[1] = createLine(grid, i               , gridEnd               , gridSize);     // vertical
			lines[2] = createLine(grid, i               , gridEnd - i * gridSize, gridSize + 1); // diagonal '\' starting top
			lines[3] = createLine(grid, i * gridSize    , gridEnd               , gridSize + 1); // diagonal '\' starting left 
			lines[4] = createLine(grid, i               , (i + 1) * gridSize    , gridSize - 1); // diagonal '/' starting top
			lines[5] = createLine(grid, i + gridSize - 1, gridEnd               , gridSize - 1); // diagonal '/' starting right
			
			for (int[] line : lines) {
				for (int lineIndex = 0; lineIndex < line.length - sequenceLength; lineIndex++) {
					int product = 1;
					for (int j = 0; j < sequenceLength; j++) {
						product *= line[lineIndex + j];
					}
					if (product > maxProduct) {
						maxProduct = product;
					}
				}
			}
		}
		System.out.println(maxProduct);
		
		Timer.stop();
	}
	
	private static int[] createLine(int[] grid, int start, int end, int step) {
		int[] line = new int[(end - 1 - start) / step + 1];
		int lineIndex = 0;
		for (int gridIndex = start; gridIndex < end; gridIndex += step) {
			line[lineIndex++] = grid[gridIndex];
		}
		return line;
	}

}
