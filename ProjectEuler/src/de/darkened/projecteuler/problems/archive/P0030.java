package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.Timer;

public class P0030 {

    public static void main(String[] args) {
        Timer.start();

        int exponent = 5;
        int[] powers = new int[10];
        for (int i = 0; i < 10; i++) {
            powers[i] = (int) Math.pow(i, exponent);
        }
        
        int sum = 0;
        for (int n = 2; n < 1000000; n++) {
            // sum of digit power 5
            int powerSum = 0;
            int digitized = n;
            while (digitized > 0) {
                powerSum += powers[digitized % 10];
                digitized /= 10;
            }
            if (powerSum == n) {
                System.out.println(n);
                sum += n;
            }
        }
        System.out.println(sum);

        Timer.stop();
    }

}
