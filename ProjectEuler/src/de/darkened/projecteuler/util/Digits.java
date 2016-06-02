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
        return isNDigitPandigital(number, false);
    }
    
    public static boolean isNDigitPandigital(long number, boolean withZero) {
        boolean foundZero = false;
        int digitMask = 1;
        long rest = number;
        int resultingMask = withZero ? 1 : 2;
        while (rest > 0) {
            resultingMask = resultingMask << 1;
            int digit = (int) (rest % 10);
            if (digit == 0) {
                foundZero = true;
            } else {
                int mask = 1 << digit;
                if ((digitMask & mask) == 0) {
                    digitMask += mask;
                } else {
                    return false;
                }
            }
            rest /= 10;
        }
        resultingMask--;
        return digitMask == resultingMask && (!withZero || foundZero);
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
    
    public static long reverse(long current) {
        long reverse = 0;
        while (current > 0) {
            reverse = reverse * 10 + current % 10;
            current /= 10;
        }
        return reverse;
    }
    
    public static int digitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static int digitSquareSum(int number) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit * digit;
            number /= 10;
        }
        return sum;
    }

}
