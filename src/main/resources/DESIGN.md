
# DESIGN.md

## Decizii de Design

### Structură

* **Clasa principală**: `AnagramReader.java` – se ocupă cu citirea fișierului și afișarea rezultatului.
* **Clasa logică**: `AnagramFinder.java` – conține logica principală pentru gruparea anagramelor.

### Arhitectură

* Se respectă principiul **separării responsabilităților**:

    * `AnagramFinder`: responsabil cu logica (maparea și gruparea anagramelor).
    * `AnagramReader`: responsabil cu input/output și apelul logicii.

### Structuri de date folosite

* **Map\<String, List**\*\*>\*\* este folosit pentru gruparea anagramelor:

    * cheia este forma sortată a cuvântului
    * valoarea este o listă de cuvinte care se potrivesc cu acea cheie

#### Exemplu:

Pentru cuvintele `race`, `care`, `acre`:

* cheie sortată: `acer`
* mapare: `"acer" -> [race, care, acre]`

### Motivare

* Folosirea unui `HashMap` oferă eficiență O(1) în medie pentru inserare și căutare.
* Sortarea fiecărui cuvânt este O(n log n), dar e justificată pentru identificarea anagramelor.

---

##  Considerații de Scalabilitate

### 10 milioane de cuvinte

* Se poate procesa fără modificări semnificative.
* Se recomandă:

    * folosirea `BufferedReader` pentru citirea rapidă a fișierelor
    * alocarea unui heap mai mare (prin parametru JVM)

###  100 de miliarde de cuvinte

* Soluția actuală nu este scalabilă direct pentru acest volum.
* Se pot aplica următoarele strategii:

    * procesarea fișierului în **bucăți (chunks)**
    * salvarea rezultatelor parțiale pe disc (ex: folosind fișiere temporare sau baze de date)
    * folosirea unui sistem distribuit (Apache Hadoop, Spark)
    * utilizarea MapReduce pentru a grupa eficient datele

##  Tratarea Erorilor

* Tratare simplificată a erorilor (doar `IOException`).
* Se ignoră liniile goale automat în timpul procesării.

##  Librării externe

* Nu s-au folosit librării externe.
* Proiectul se bazează doar pe bibliotecile standard din Java.

---

##  Concluzie

* Arhitectură curată și logică simplă.
* Ușor de întreținut și extins.
* Scalabil pentru volume mari cu mici ajustări.
* Potrivit pentru rulare locală sau adaptabil pentru sisteme mari de procesare distribuită.

---