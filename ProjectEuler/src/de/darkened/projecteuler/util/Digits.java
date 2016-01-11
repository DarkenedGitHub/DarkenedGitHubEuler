package de.darkened.projecteuler.util;

public class Digits {

    public static boolean isPandigital(int[] numbers) {
        boolean[] digitFound = new boolean[10];
        int digitCount = 0;
        for (int number : numbers) {
            while (number > 0) {
                if (digitCount >= 9) {
                    return false;
                }
                int digit = number % 10;
                if (digit == 0 || digitFound[digit]) {
                    return false;
                }
                digitFound[digit] = true;
                digitCount++;
                number /= 10;
            }
        }
        return digitCount == 9;
    }
    
    public static boolean isNDigitPandigital(int number) {
        int digitMask = 1;
        int rest = number;
        int resultingMask = 2;
        while (rest > 0) {
            resultingMask = resultingMask << 1;
            int digit = rest % 10;
            int mask = 1 << digit;
            if ((digitMask & mask) == 0) {
                digitMask += mask;
            } else {
                return false;
            }
            rest /= 10;
        }
        resultingMask--;
        return digitMask == resultingMask;
    }

    public static int horner(int number, int base, int[] digits) {
        int digitCount = 0;
        while(number > 0) {
            digits[digitCount] = number % base;
            number /= base;
            digitCount++;
        }
        return digitCount;
    }
    
    public static boolean isPalindrome(int[] digits, int digitCount) {
        for (int i = 0; i < digitCount / 2; i++) {
            if (digits[i] != digits[digitCount - i - 1]) {
                return false;
            }
        }
        return true;
    }

}
