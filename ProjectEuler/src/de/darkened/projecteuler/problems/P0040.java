package de.darkened.projecteuler.problems;

import de.darkened.projecteuler.util.Timer;

public class P0040 {

    public static void main(String[] args) {
        Timer.start();

        int bound = 1000000;
        
        int powerOf10 = 1;
        int exp = 0;
        int currentDigitCount = 0;
        int product = 1;
        for (int d = 1; d <= bound; d *= 10) {
            while (currentDigitCount < d) {
                exp++;
                currentDigitCount += exp * powerOf10 * 9;
                powerOf10 *= 10;
            }
            int digitOffset = currentDigitCount - d; // negative offset
            int numberOffset = digitOffset / exp + 1;
            int number = powerOf10 - numberOffset;
            int digitIndex = digitOffset % exp;
            while (digitIndex > 0) {
                number /= 10;
                digitIndex--;
            }
            int digit = number % 10;
            product *= digit;
        }
        System.out.println(product);

        Timer.stop();
    }

}
