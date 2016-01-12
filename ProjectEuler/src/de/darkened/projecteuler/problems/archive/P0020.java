package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.BigDecimalInt;
import de.darkened.projecteuler.util.Timer;

public class P0020 {
    
    public static void main(String[] args) {
        Timer.start();
        
        BigDecimalInt factorial = new BigDecimalInt(1);
        for (int i = 2; i <= 100; i++) {
            factorial = factorial.multiply(i);
        }
        int digitSum = 0;
        for (int digit : factorial.toDigits()) {
            digitSum += digit;
        }
        System.out.println(digitSum);
        
        Timer.stop();
    }

}
