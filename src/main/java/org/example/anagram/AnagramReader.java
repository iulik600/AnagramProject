package org.example.anagram;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnagramReader {
    public static void main(String[] args) {
        List<String> words = readWordsFromFile();

        if (words != null && !words.isEmpty()) {
            AnagramFinder finder = new AnagramFinder();

            Map<String, List<String>> grouped = AnagramFinder.groupAnagrams(words);

            for(List<String> group : grouped.values()) {
                System.out.println(String.join(" ", group));
            }
        } else  {
            System.out.println("No words found or failed to read the file.");
        }
    }

    private static List<String> readWordsFromFile() {
        List<String> words = new ArrayList<>();

        try {
            //Deschidem fisierul ca resursa din classpath
            InputStream inputStream = AnagramReader.class.getResourceAsStream("/sample.txt");

            if (inputStream == null) {
                System.out.println("File not found " + "/sample.txt");
                return words;
            }
            // Ciitim fiecare linie din fisier
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    words.add(line.trim());
                }
            }

        reader.close();

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return words;
    }
}
