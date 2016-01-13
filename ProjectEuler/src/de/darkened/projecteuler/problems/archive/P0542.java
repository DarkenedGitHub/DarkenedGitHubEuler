package de.darkened.projecteuler.problems.archive;

import java.util.Arrays;
import java.util.stream.LongStream;

import de.darkened.projecteuler.util.Timer;

public class P0542 {

    private static long[] squareTable;
    
    public static void main(String[] args) {
        Timer.start();
        
        long maxN = 100000000000000000L;
        int maxBaseExclusive = 90;
        int maxFactor = 1000;
        int maxExp = 25;
        
        squareTable = new long[maxBaseExclusive];
        for (long i = 0; i < maxBaseExclusive; i++) squareTable[(int) i] = i * i;
        
        double logMaxN = Math.log(maxN);
        Iterable<Long> kGenerator = LongStream.range(2, maxBaseExclusive).
                flatMap(base -> LongStream.rangeClosed(2, Math.min(maxExp, (long) (logMaxN / Math.log(base)))).
                        map(exp -> (long) Math.pow(base, exp))).
                flatMap(power -> LongStream.rangeClosed(1, Math.min(maxFactor, maxN / power)).
                        map(factor -> factor * power)).
                distinct().
                filter(k -> k >= 4).
                sorted()::iterator;
        
        long t = 0;
        long lastMaxSum = 0;
        long lastMaxK = 4;
        for (long k : kGenerator) {
            int[] possibleBases = getPossibleBases(k);
            long currMaxSum = 0;
            for (int base : possibleBases) {
                long sum = calculateSequenceSum(k, base);
                if (sum > currMaxSum) {
                    currMaxSum = sum;
                }
            }
            if (currMaxSum > lastMaxSum) {
                System.out.println("--> " + k + ": " + currMaxSum);
                if ((k - lastMaxK) % 2 != 0)
                    t += (k % 2 == 0 ? -1 : 1) * lastMaxSum;
                lastMaxSum = currMaxSum;
                lastMaxK = k;
            }
        }
        if ((maxN + 1 - lastMaxK) % 2 != 0) {
            t += (maxN % 2 == 0 ? 1 : -1) * lastMaxSum;
        }
        System.out.println(t);

        Timer.stop();
    }
    
    private static int[] getPossibleBases(long n) {
        int rootN = Math.min(squareTable.length - 1, (int) Math.sqrt(n));
        int[] bases = new int[0];
        for (int i = rootN; i >= 2; i--) {
            if (n % squareTable[i] == 0) {
                bases = Arrays.copyOf(bases, bases.length + 1);
                bases[bases.length - 1] = i;
            }
        }
        return bases;
    }
    
    private static long calculateSequenceSum(long k, int base) {
        long sum = k;
        while (k % base == 0) {
            k = k / base * (base - 1);
            sum += k;
        }
        return sum;
    }
    
}
