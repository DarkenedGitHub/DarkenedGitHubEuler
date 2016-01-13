package de.darkened.projecteuler.problems.unsolved;

import java.util.Arrays;

import de.darkened.projecteuler.util.Timer;

public class P0542 {

    private static long[] squareTable;
    
    public static void main(String[] args) {
        Timer.start();
        
        int n = 100000000;
        squareTable = new long[1000];
        for (long i = 0; i < 1000; i++) squareTable[(int) i] = i * i;

        int t = 0;
        int lastMaxSum = 0;
        int skipped = 0;
        int newMaxCount = 0;
        int overallCount = 0;
        int maxBase = 0;
        int maxExp = 0;
        int maxFactor = 0;
        for (int k = 4; k <= n; k++) {
            int[] possibleBases = getPossibleBases(k);
            int maxSum = lastMaxSum;
            int currMaxBase = 0;
            int baseOfMaxSum = 0;
            int currMaxExp = 0;
            int currMaxFactor = 0;
            for (int base : possibleBases) {
                int sum = calculateSequenceSum(k, base);
                if (sum > lastMaxSum) {
                    newMaxCount++;
//                    System.out.println("+++ " + termStr(k, base) + " .. " + sum);
                } else {
                    overallCount++;
//                    System.out.println("    " + termStr(k, base) +  " .. " + sum);
                }
                if (sum > maxSum) {
                    if (base > currMaxBase) {
                        currMaxBase = base;
                    }
                    int exp = log(k, base);
                    if (exp > currMaxExp) {
                        currMaxExp = exp;
                    }
                    int factor = getFactor(k, base);
                    if (factor > currMaxFactor) {
                        currMaxFactor = factor;
                    }
                    maxSum = sum;
                    baseOfMaxSum = base;
                }
            }
            if (currMaxBase > maxBase) {
                maxBase = currMaxBase;
                System.out.println("maxBase: " + maxBase + "(" + k + ")");
            }
            if (currMaxExp > maxExp) {
                maxExp = currMaxExp;
                System.out.println("maxExp: " + maxExp + "(" + k + ")");
            }
            if (currMaxFactor > maxFactor) {
                maxFactor = currMaxFactor;
                System.out.println("maxFactor: " + maxFactor + "(" + k + ")");
            }
            if (maxSum > lastMaxSum) {
                System.out.println("--> " + k + ": " + maxSum + " (" + baseOfMaxSum + ")");
                if (skipped % 2 == 0)
                    t += (k % 2 == 0 ? -1 : 1) * lastMaxSum;
//                System.out.println("T_ " + (t + (k % 2 == 0 ? 1 : -1) * maxSum));
                skipped = 0;
                lastMaxSum = maxSum;
            } else {
                skipped++;
            }
//            System.out.println("---------------------------------------------------");
            
        }
        if (skipped % 2 == 0)
            t += (n % 2 == 0 ? 1 : -1) * lastMaxSum;
        System.out.println(t);
        System.out.println(newMaxCount + "/" + overallCount);
        System.out.println("max base: " + maxBase);
        System.out.println("max exp: " + maxExp);
        System.out.println("max factor: " + maxFactor);

        Timer.stop();
    }
    
    private static int[] getPossibleBases(int n) {
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
    
    private static int calculateSequenceSum(int k, int base) {
        int sum = k;
        while (k % base == 0) {
            k = k / base * (base - 1);
            sum += k;
        }
        return sum;
    }
    
    private static String termStr(int k, int base) {
        int exp = 0;
        while (k % base == 0) {
            exp++;
            k /= base;
        }
        return k + "*" + base + "^" + exp;
    }
    
    private static int log(int k, int base) {
        int exp = 0;
        while (k % base == 0) {
            exp++;
            k /= base;
        }
        return exp;
    }
    
    private static int getFactor(int k, int base) {
        while (k % base == 0) {
            k /= base;
        }
        return k;
    }
    
}
