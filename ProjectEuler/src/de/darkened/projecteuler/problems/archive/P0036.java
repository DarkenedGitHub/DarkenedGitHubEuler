package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.Digits;
import de.darkened.projecteuler.util.Timer;

public class P0036 {
    
    public static void main(String[] args) {
        Timer.start();
        
        int[] digits = new int[20];
        int sum = 0;
        for (int number = 1; number < 1000000; number++) {
            if (Digits.isPalindrome(digits, Digits.horner(number, 10, digits)) && 
                    Digits.isPalindrome(digits, Digits.horner(number, 2, digits))) {
                sum += number;
            }
        }
        System.out.println(sum);
        
        Timer.stop();
    }
    
}
