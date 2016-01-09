package de.darkened.projecteuler.util;

public class MathMore {
    
    public static int gcd(int a, int b) {
        if (a > b) {
            int c = b;
            b = a;
            a = c;
        }
        while (b % a != 0) {
            int c = b % a;
            b = a;
            a = c;
        }
        return a;
    }

}
