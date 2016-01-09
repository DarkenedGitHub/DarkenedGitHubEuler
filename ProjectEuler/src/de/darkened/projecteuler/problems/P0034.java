package de.darkened.projecteuler.problems;

import de.darkened.projecteuler.util.Timer;

public class P0034 {
    
    public static void main(String[] args) {
        Timer.start();
        
        int bound = 1000000; // 7*9! is below that, so for higher numbers, the facturial-sum is definitely lower
        
        int[] factorial = new int[10];
        factorial[0] = 1;
        for (int i = 1; i < 10; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        
        int result = 0;
        for (int number = 10; number < bound || number == 1999999; number++) {
            int factorialSum = 0;
            int hornered = number;
            while (hornered > 0) {
                factorialSum += factorial[hornered % 10];
                hornered /= 10;
            }
            if (factorialSum == number) {
                result += number;
            }
        }
        System.out.println(result);

        Timer.stop();
    }

}
