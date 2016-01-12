package de.darkened.projecteuler.problems;

import de.darkened.projecteuler.util.DataLoader;
import de.darkened.projecteuler.util.Timer;

public class P0042 {
    
    public static void main(String[] args) {
        String[] words = DataLoader.getStrings(P0042.class.getSimpleName());
        Timer.start();
        
        boolean[] triangleNumbers = new boolean[200];
        for (int i = 0; i * i + i < 2 * triangleNumbers.length; i++) {
            triangleNumbers[(i * (i + 1)) / 2] = true;
        }
        
        int count = 0;
        for (String word : words) {
            if (triangleNumbers[word.chars().sum() - 64 * word.length()]) {
                count++;
            }
        }
        System.out.println(count);
        
        Timer.stop();
    }

}
