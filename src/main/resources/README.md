# README.md

## Anagram Finder

Acesta este un program Java simplu care citește o listă de cuvinte dintr-un fișier și grupează anagramele împreună. O anagramă este un cuvânt format prin rearanjarea literelor unui alt cuvânt, cum ar fi `care` și `race`.

### Cerințe

* Java 17+

### Cum compilezi și rulezi

1. **Clonează sau descarcă** proiectul.

2. **Asigură-te că fișierul** `sample.txt` este în directorul `resources`.

3. **Compilează fișierele Java**:

```bash
javac -d out src/main/java/org/example/anagram/*.java
```

4. **Rulează programul**:

```bash
java -cp out org.example.anagram.AnagramReader
```

### Input

Fișierul `resources/sample.txt` conține câte un cuvânt pe linie:

```
act
cat
tree
race
care
acre
bee
```

###  Output așteptat

```
act cat
race care acre
tree
bee
```

Programul afișează grupurile de anagrame, fiecare pe o linie diferită, în ordine alfabetică a cheilor generate (forme sortate).



