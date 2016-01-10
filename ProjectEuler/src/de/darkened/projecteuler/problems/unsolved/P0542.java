package de.darkened.projecteuler.problems.unsolved;

import de.darkened.projecteuler.util.Timer;

public class P0542 {
    
    private static long[] squareTable;

    public static void main(String[] args) {
        Timer.start();
        
        int n = 100;
        squareTable = new long[n];
        for (long i = 0; i < n; i++) squareTable[(int) i] = i * i;

        int t = 0;
        int lastMaxSum = 0;
        int skipped = 0;
        int newMaxCount = 0;
        for (int k = 4; k <= n; k++) {
            int maxSum = 0;
            for (int squareIndex = k - 1; squareIndex > 1 && squareTable[squareIndex] >= k; squareIndex--) {
                if (squareTable[squareIndex] % k == 0) {
                    // build sequence and sum up
                    long next = squareTable[squareIndex] / k;
                    int sum = (int) (k + squareIndex + next);
                    int a = squareIndex;
                    int b = (int) next;
                    while (squareTable[b] % a == 0) {
                        long c = squareTable[b] / a;
                        sum += c;
                        a = b;
                        b = (int) c;
                    }
                    if (sum > lastMaxSum && sum > maxSum) {
                        maxSum = sum;
                        System.out.println(".. " + k + " " + squareIndex);
                    }
                    if (sum > lastMaxSum) {
                        newMaxCount++;
                        System.out.println(".. " + k + " " + squareIndex);
                    }
                }
            }
            if (maxSum > 0) {
                System.out.println(k + ": " + maxSum);
                if (skipped % 2 == 0)
                    t += (k % 2 == 0 ? -1 : 1) * lastMaxSum;
                skipped = 0;
                lastMaxSum = maxSum;
            } else {
                skipped++;
            }
        }
        if (skipped % 2 == 0)
            t += (n % 2 == 0 ? 1 : -1) * lastMaxSum;
        System.out.println(t);

        createSequence(2, 9, 2);
        
        
        Timer.stop();
    }
    
    private static void createSequence(int coeff, int base, int exp) {
        if (coeff == base * base) {
            base = coeff;
            coeff = 1;
        }
        
        int a = base;
        for (int i = 1; i < exp; i++) a *= base;
        a *= coeff;
        StringBuilder sb = new StringBuilder("seq ");
        sb.append(coeff).append("*").append(base).append("^").append(exp).append(" -> ");
        sb.append(a);
        for (int i = 0; i < exp; i++) {
            a = a / base * (base - 1);
            sb.append(" ").append(a);
        }
        System.out.println(sb);
    }
    
}
