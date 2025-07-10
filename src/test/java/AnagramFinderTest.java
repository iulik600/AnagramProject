import org.example.anagram.AnagramFinder;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramFinderTest {
    @Test
    void testGroupAnagrams_withSimpleWords() {
        AnagramFinder finder = new AnagramFinder();

        List<String> words = Arrays.asList("act", "cat", "tree", "race", "care", "acre", "bee");

        Map<String, List<String>> grouped = AnagramFinder.groupAnagrams(words);

        // Verificam ca exista 4 grupuri (act/cat, race/care/acre, tree, bee)
        assertEquals(4, grouped.size());

        // Verificam că "act" si "cat" sunt in același grup
        boolean foundActCat = grouped.values().stream().anyMatch(g -> g.containsAll(Arrays.asList("act", "cat")));
        assertTrue(foundActCat);

        // Verificam ca "race", "care", "acre" sunt impreuna
        boolean foundRaceCareAcre = grouped.values().stream().anyMatch(g -> g.containsAll(Arrays.asList("race", "care", "acre")));
        assertTrue(foundRaceCareAcre);
    }

}
