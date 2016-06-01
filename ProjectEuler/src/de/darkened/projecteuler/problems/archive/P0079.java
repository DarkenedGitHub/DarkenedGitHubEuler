package de.darkened.projecteuler.problems.archive;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.darkened.projecteuler.util.DataLoader;
import de.darkened.projecteuler.util.Timer;

public class P0079 {

    public static void main(String[] args) {
        List<String> lines = DataLoader.getDataLines(P0079.class.getSimpleName()).collect(Collectors.toList());
        Timer.start();
        
        List<String> chars = lines.stream().
                flatMap(s -> Stream.of(s.split(""))).
                distinct().
                collect(Collectors.toList());
        
        // get map with links
        Map<String, Set<String>> successors = new HashMap<>();
        for (String line : lines) {
            for (int charIndex = 0; charIndex < line.length() - 1; charIndex++) {
                String char1 = line.substring(charIndex, charIndex + 1);
                String char2 = line.substring(charIndex + 1, charIndex + 2);
                if (!successors.containsKey(char1)) {
                    successors.put(char1, new HashSet<>());
                }
                successors.get(char1).add(char2);
            }
        }
        
        // search which char is not successor of remaining chars...
        String passcode = "";
        while (!chars.isEmpty()) {
            Set<String> nonSuccessorChars = new HashSet<>(chars);
            nonSuccessorChars.removeAll(successors.values().stream().flatMap(Collection::stream).collect(Collectors.toSet()));
            if (nonSuccessorChars.isEmpty()) {
                System.out.println("circle found!: " + chars);
                System.exit(1);
            }
            String nextChar = nonSuccessorChars.iterator().next();
            chars.remove(nextChar);
            // and remove it as a predecessor
            successors.remove(nextChar);
            passcode += nextChar;
        }
        System.out.println(passcode);
        
        Timer.stop();
    }

}
