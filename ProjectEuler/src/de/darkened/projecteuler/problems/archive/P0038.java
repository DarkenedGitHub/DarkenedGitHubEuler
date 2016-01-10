package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.Digits;
import de.darkened.projecteuler.util.Timer;

public class P0038 {
    
    public static void main(String[] args) {
        Timer.start();
        
        // CP(9x12345) = 918273645 --> our start number must begin with 9
        // length 1 -> start = 9 -> given example
        // length 2 -> prodlength = 2,2,2,3 -> 25 <= start <= 33 -> starts not with 9
        // length 3 -> 3 <= prodlength -> n <= 3 -> prodlength <= 4 -> only 3x3 possible -> start <= 333 -> starts not with 9
        // length 4 -> n = 2 -> prodlength = 4,5-> 5000 <= start <= 9999 -> 9000 <= start <= 9999
        // --> check only 9182..9876 (reverse order) with n = 2; if result for 9182, check against example
        
        int result = 0;
        for (int number = 9876; number >= 9182; number--) {
            if (Digits.isPandigital(new int[] {number, number * 2})) {
                result = number * 100000 + number * 2;
                break;
            }
        }
        System.out.println(result);
        if (result < 918273645) {
            System.out.println("example was bigger: 918273645");
        }
        
        Timer.stop();
    }

}
