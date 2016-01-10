package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.Timer;

public class P0031 {
    
    public static void main(String[] args) {
        Timer.start();
        
        System.out.println(permutations(new int[]{200, 100, 50, 20, 10, 5, 2, 1}, 0, 200));
        
        Timer.stop();
    }
    
    private static int permutations(int[] coins, int coinIndex, int rest) {
        if (coinIndex == coins.length - 1) {
            return 1;
        }
        int count = 0;
        while (rest >= 0) {
            count += permutations(coins, coinIndex + 1, rest);
            rest -= coins[coinIndex];
        }
        return count;
    }

}
