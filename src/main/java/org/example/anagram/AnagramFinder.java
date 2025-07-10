package org.example.anagram;

import java.util.*;

public class AnagramFinder {

    // Metoda principală care citește și grupează anagramele
    public static Map<String, List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String word : words) {
            // Ignoram liiniile goale sau cuvintele nule
            if (word == null || word.trim().isEmpty()) {
                continue;
            }

            String cleanWord = word.trim();

            String sortedKey = sortLetters(cleanWord);

            anagramGroups.putIfAbsent(sortedKey, new ArrayList<>());

            anagramGroups.get(sortedKey).add(cleanWord);
        }

        return anagramGroups;
    }

    private static String sortLetters(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
