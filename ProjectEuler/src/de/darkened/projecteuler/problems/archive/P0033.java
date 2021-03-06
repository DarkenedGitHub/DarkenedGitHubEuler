package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.MathMore;
import de.darkened.projecteuler.util.Timer;

public class P0033 {
    
    public static void main(String[] args) {
        Timer.start();
        
        int numeratorProduct = 1;
        int denominatorProduct = 1;
        for (int numerator = 11; numerator < 100; numerator++) {
            int n1 = numerator / 10;
            int n2 = numerator % 10;
            for (int denominator = 11; denominator < 100; denominator++) {
                int d1 = denominator / 10;
                int d2 = denominator % 10;
                if (n1 != n2 && d1 == n2 && denominator * n1 == numerator * d2) {
                    System.out.println(numerator + "/" + denominator);
                    numeratorProduct *= numerator;
                    denominatorProduct *= denominator;
                }
            }
        }
        System.out.println("product: " + (numeratorProduct + "/" + denominatorProduct));
        System.out.println("result: " + (denominatorProduct / MathMore.gcd(numeratorProduct, denominatorProduct)));
        
        Timer.stop();
    }
    
}
