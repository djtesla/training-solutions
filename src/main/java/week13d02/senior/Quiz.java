package week13d02.senior;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz {

    public static final String FILE = "C:\\Training\\training-solutions\\src\\main\\java\\week13d02\\senior\\results.txt";

    private List<Character> goodAnswers = new ArrayList<>();

    public Map<String, List<Character>> readFileAndCreateQuizMap(String file) {
        Map<String, List<Character>> quizMap = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
            goodAnswers = readHeader(reader);
            String line;
            while ((line = reader.readLine()) != null) {
                putMapEntryPerLine(quizMap, line);
            }
            return quizMap;

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }


    private List<Character> readHeader(BufferedReader reader) throws IOException {
        List<Character> goodAnswers = new ArrayList<>();
        String answersStr = reader.readLine();
        for (char c : answersStr.toCharArray()) {
            goodAnswers.add(c);
        }
        return goodAnswers;
    }



    private void putMapEntryPerLine(Map<String, List<Character>> quizMap, String line) {
        String player = line.split(" ")[0];
        char tip = line.split(" ")[1].charAt(0);
        List<Character> tips = new ArrayList<>();
        if (quizMap.containsKey(player)) {
            tips = quizMap.get(player);
        }
        tips.add(tip);
        quizMap.put(player, tips);
    }



    //Legyen egy lekérdező metódus ami paraméterül vár egy kódot és egy számot és megmondja
    public boolean isAnswerGood(String player, int questionNo) {
        List<Character> playerAnswers = readFileAndCreateQuizMap(FILE).get(player);
        return goodAnswers.get(questionNo-1) == playerAnswers.get(questionNo-1);
    }


    //Legyen egy metódus ami visszaadja annak versenyzőnek a kódját, akinek a legtöbb X szerepel a válaszai között.
    public String getPlayerWithMaxHits () {
        Map<String, List<Character>> playersAnswers = readFileAndCreateQuizMap(FILE);
        String playerWithMinHits = null;
        int maxHits = Integer.MIN_VALUE;
        for (Map.Entry<String, List<Character>> entry : playersAnswers.entrySet()) {
            int playerHits = getHitsPerPlayer(entry.getValue());
            if (playerHits > maxHits) {
                maxHits = playerHits;
                playerWithMinHits = entry.getKey();
            }
        }
        return playerWithMinHits;
    }


    private int getHitsPerPlayer(List<Character> answers) {
        int score = 0;
        int s = goodAnswers.size()-1;
        for (int i =0; i<s; i++) {
            if (goodAnswers.get(i) == answers.get(i)) {
                score++;
            }
        }
        return score;
    }



    public String getPlayerWithMostSkip () {
        Map<String, List<Character>> playersAnswers = readFileAndCreateQuizMap(FILE);
        String playerWithMaxSkip = null;
        int maxSkip = Integer.MIN_VALUE;
        for (Map.Entry<String, List<Character>> entry : playersAnswers.entrySet()) {
            int playerHits = getSkipsPerPlayer(entry.getValue());
            if (playerHits > maxSkip) {
                maxSkip = playerHits;
                playerWithMaxSkip = entry.getKey();
            }
        }
        return playerWithMaxSkip;
    }


    private int getSkipsPerPlayer(List<Character> answers) {
        int skips = 0;
        for (char c : answers) {
            if (c == 'X') {
                skips++;
            }
        }
        return skips;
    }




    private Map<String, Integer> getPointsOfPlayers() {
        Map<String, Integer> scoreMap = new HashMap<>();
        Map<String, List<Character>> quizMap = readFileAndCreateQuizMap(FILE);
        for (Map.Entry<String, List<Character>> entry : quizMap.entrySet() ) {
            int score = getScore(entry.getValue());
            scoreMap.put(entry.getKey(), score);
        }
        return scoreMap;
    }



    private int getScore(List<Character> answers) {
        int score = 0;
        for (int i = 0; i < answers.size(); i++) {
            char answerChr = answers.get(i);
            if (isScore(i, answerChr)) {
                score += i + 1;
            } else if (answerChr != 'X') {
                score -= 2;
            }
        }
        return score > - 1 ? score : 0;
    }


    private boolean isScore(int i, Character answer) {
        return goodAnswers.get(i) == answer;
    }




    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        Map<String, List<Character>> quizMap = quiz.readFileAndCreateQuizMap(FILE);
        System.out.println(quizMap);
        System.out.println(quiz.goodAnswers);
        System.out.println(quiz.isAnswerGood("AB123", 2));
        System.out.println(quiz.getPlayerWithMaxHits());
        System.out.println(quiz.getPlayerWithMostSkip());
        System.out.println(quiz.getPointsOfPlayers());


    }


}



    /*Egy internetes kvíz versenyen egy fájlba rögzitettük a versenyzők válaszait.
        A versenyzők egyszerre kezdtek és egyszerre egy kérdésre válaszoltak meg.
        A fájlban az egyes versenyzők válaszai sorban szerepelnek, de a fájlban a sorok a
        beérkezett válaszok sorrendjében találhatók. PL.:

        ABACD
        AB123 A
        AH2 B
        BD452 A
        AB123 B
        GH1234 C
        AB123 D
        Magyarázat:A fájl első sora a helyes válaszokat tartalmazza egy sorban.
        (5 kérdés volt az elsőre a helyes válasz A a másodikra B stb.)
        Ezek után a sor első eleme egy azonosító a második pedig egy a válasz betűjele.
        Minden kérdésnél négy válaszlehetőség volt (A,B,C,D) és lehetett ugrani egy kérdést
        ekkor X szerepel a fájlban. Tehát az AB123 azonosítóval rendelkező játékos első válasza
        A a második B. A többieknek csak az első kérdésre adott válaszuk szerepel a példában.
        Feladatok:

        Olvasd be a fájl tartalmát a memóriába.
        Legyen egy lekérdező metódus ami paraméterül vár egy kódot és egy számot és megmondja
        hogy az ileltő az adott kérdésre helyesen vagy helytelenül válaszolt-e.
        Legyen egy metódus ami visszaadja annak versenyzőnek a kódját, akinek a legtöbb X szerepel
        a válaszai között.
        Adjuk vissza annak a versenyzőnek a kódját, aki a legtöbb pontot szerezte.
        Pont a helyes válaszért jár méghozzá annyi, ahányadik kérdés volt a sorban.
        Az első kérdés egy pontos a második kettő stb. Bonusz: X az 0 pont, de a rossz válasz -2.
        Fájl elérhető:examples\week13d02\src\main\resources\results.txt*/
