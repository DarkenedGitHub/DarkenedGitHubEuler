package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.Timer;

public class P0017 {
    
    public static void main(String[] args) {
        Timer.start();
        
        int[] ones = new int[] { 3, 3, 5, 4, 4, 3, 5, 5, 4}; // 1..9
        int[] elvs = new int[] { 3, 6, 6, 8, 8, 7, 7, 9, 8, 8}; // 10..19
        int[] tens = new int[] { 6, 6, 5, 5, 5, 7, 6, 6 }; // 20..90
        int and = 3;
        int hundred = 7;
        int thousand = 8;
        
        int sumOnes = 0;
        int sumElvs = 0;
        int sumTens = 0;
        for (int i : ones) sumOnes += i;
        for (int i : elvs) sumElvs += i;
        for (int i : tens) sumTens += i;
        
        int sumTo99 = sumTens * 10 + sumOnes * tens.length + sumElvs + sumOnes;
        int sumTo999 = sumOnes * 100 + hundred * ones.length * 100 + ones.length * 99 * and + ones.length * sumTo99 + sumTo99;
        int sum = sumTo999 + ones[0] + thousand;
        
        System.out.println(sum);
        
        Timer.stop();
    }

}
