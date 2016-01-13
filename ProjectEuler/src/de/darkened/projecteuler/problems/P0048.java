package de.darkened.projecteuler.problems;

import de.darkened.projecteuler.util.Timer;

public class P0048 {
    
    public static void main(String[] args) {
        Timer.start();
        
        long mod = 10000000000L;
        long sum = 0;
        for (int i = 1; i <= 1000; i++) {
            long power = 1;
            for (int exp = 1; exp <= i; exp++) {
                power = (power * i) % mod;
            }
            sum += power;
        }
        long result = sum % mod;
        System.out.println(result);
        
        Timer.stop();
    }

}
