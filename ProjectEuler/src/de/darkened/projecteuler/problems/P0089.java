package de.darkened.projecteuler.problems;

import java.util.stream.Stream;

import de.darkened.projecteuler.util.DataLoader;
import de.darkened.projecteuler.util.Timer;

public class P0089 {

    public static void main(String[] args) {
        Stream<String> lines = DataLoader.getDataLines(P0089.class.getSimpleName());
        Timer.start();

        int saved = lines.mapToInt(roman -> {
            String minimal = roman.
                    replace("IIII", "IV").
                    replace("VIV", "IX").
                    replace("XXXX", "XL").
                    replace("LXL", "XC").
                    replace("CCCC", "CD").
                    replace("DCD", "CM");
            return roman.length() - minimal.length();
        }).sum();
        System.out.println(saved);
        
        Timer.stop();
    }

}
