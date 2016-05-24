package de.darkened.projecteuler.problems.archive;

import de.darkened.projecteuler.util.Timer;

public class P0045 {
    
    public static void main(String[] args) {
        Timer.start();
        
        // T(n)=H(m) for n=2m-1 --> only check pentagonal and hexagonal
        long p = 40756;
        long pIndex = 165;
        long h = 40755;
        long hIndex = 143;

        while (p != h) {
            while (p < h) {
                pIndex++;
                p = (pIndex) * (3 * pIndex - 1) / 2;
            }
            while (h < p) {
                hIndex++;
                h = (hIndex) * (2 * hIndex - 1);
            }
        }
        System.out.println(p);
        
        Timer.stop();
    }

}
