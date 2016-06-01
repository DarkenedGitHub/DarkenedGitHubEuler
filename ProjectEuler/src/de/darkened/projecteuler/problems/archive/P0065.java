package de.darkened.projecteuler.problems.archive;

import java.math.BigInteger;

import de.darkened.projecteuler.util.Timer;

public class P0065 {

    public static void main(String[] args) {
        Timer.start();
        
        int convergentPosition = 100;
        ContinuedFraction fraction = new ContinuedFraction();
        fraction.numerator = BigInteger.valueOf(0);
        fraction.denominator = BigInteger.valueOf(digitAt(convergentPosition));
        for (int i = convergentPosition; i > 1; i--) {
            int extensionNumber = digitAt(i + 2);
            fraction = fraction.extendBy(extensionNumber);
        }
        System.out.println(fraction.finished(2));

        int digitSum = 0;
        BigInteger result = fraction.finished(2).numerator;
        BigInteger[] resultAndRemainder;
        do {
            resultAndRemainder = result.divideAndRemainder(BigInteger.TEN);
            digitSum += Math.abs(resultAndRemainder[1].intValue());
            result = resultAndRemainder[0];
        } while (result.compareTo(BigInteger.ZERO) != 0);
        System.out.println(digitSum);
        
        Timer.stop();
    }
    
    static int digitAt(int position) {
        return position % 3 == 2 ? position / 3 * 2 : 1;
    }
    
    static class ContinuedFraction {
        BigInteger numerator = BigInteger.valueOf(1);
        BigInteger denominator = BigInteger.valueOf(2);
        ContinuedFraction extendBy(long extensionNumber) {
            ContinuedFraction extended = new ContinuedFraction();
            extended.numerator = denominator;
            extended.denominator = denominator.multiply(BigInteger.valueOf(extensionNumber)).add(numerator);
            return extended;
        }
        public ContinuedFraction finished(int base) {
            ContinuedFraction finished = extendBy(base);
            BigInteger x = finished.numerator;
            finished.numerator = finished.denominator;
            finished.denominator = x;
            return finished;
        }
        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }
    }

}
