package de.darkened.projecteuler.problems;

import de.darkened.projecteuler.util.Timer;

public class P0036 {
    
    public static void main(String[] args) {
        Timer.start();
        
        int[] digits = new int[20];
        int sum = 0;
        for (int number = 1; number < 1000000; number++) {
            if (isPalindrome(digits, horner(number, 10, digits)) && isPalindrome(digits, horner(number, 2, digits))) {
                sum += number;
            }
        }
        System.out.println(sum);
        
        Timer.stop();
    }
    
    private static int horner(int number, int base, int[] digits) {
        int digitCount = 0;
        while(number > 0) {
            digits[digitCount] = number % base;
            number /= base;
            digitCount++;
        }
        return digitCount;
    }
    
    private static boolean isPalindrome(int[] digits, int digitCount) {
        for (int i = 0; i < digitCount / 2; i++) {
            if (digits[i] != digits[digitCount - i - 1]) {
                return false;
            }
        }
        return true;
    }

}
