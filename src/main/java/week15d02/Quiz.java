package week15d02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Quiz {

    List<Question> questions = new ArrayList<>();

    public List<Question> getQuestions() {
        return questions;
    }


    public void readAndUpload(String file) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
            String titleLine;
            while ((titleLine = reader.readLine()) != null) {
                String dataLine = reader.readLine();
                questions.add(getNewQuestion(titleLine, dataLine));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot ead file", ioe);
        }
    }


    private Question getNewQuestion(String titleLine, String dataLine) {
        String[] data = dataLine.split(" ");
        String answer = data[0];
        int score = Integer.parseInt(data[1]);
        String subject = data[2];
        return new Question(titleLine, answer, score, subject);
    }


    public List<String> getAllQuestionsBySubject(String subject) {
        if (isEmpty(subject)) {
            throw new IllegalArgumentException("Subject cannot be null or empty!");
        }
        List<String> allQuestionsBySubject = new ArrayList<>();
        for (Question question : questions) {
            if (question.getSubject().equals(subject)) {
                allQuestionsBySubject.add(question.getTitle());
            }
        }
        return allQuestionsBySubject;
    }


    public Map<String, List<Question>> summarize() {
        Map<String, List<Question>> summary = new TreeMap<>();
        for (Question question : questions) {
            List<Question> questionsBySubject = new ArrayList<>();
            String focusedSubject = question.getSubject();
            if (summary.containsKey(focusedSubject)) {
                questionsBySubject = summary.get(focusedSubject);
                questionsBySubject.add(question);
            } else {
                questionsBySubject.add(question);
                summary.put(focusedSubject, questionsBySubject);
            }
        }
        return summary;
    }


    public Question getRandomQuestion(Random random) {
        int i = random.nextInt(questions.size());
        return questions.get(i);
    }


    public Map<String, Integer> getSumOfScoresBySubject() {
        Map<String, List<Question>> summary = summarize();
        Map<String, Integer> scoresBySubject = new TreeMap<>();
        for (Map.Entry<String, List<Question>> entry : summary.entrySet()) {
            List<Question> questionsBySubject = entry.getValue();
            int sumOfScores = getSum(questionsBySubject);
            scoresBySubject.put(entry.getKey(), sumOfScores);
        }
        return scoresBySubject;
    }


    private int getSum(List<Question> questionsBySubject) {
        int sum = 0;
        for (Question question: questionsBySubject) {
            sum += question.getScore();
        }
        return sum;
    }


    private boolean isEmpty(String text) {
        return text == null || text.equals("");
    }


    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.readAndUpload("kerdesek.txt");
        //System.out.println(quiz.getAllQuestionsBySubject("matematika"));
        //System.out.println(quiz.summarize());
        System.out.println(quiz.getSumOfScoresBySubject());
    }


    // question, answer, topic, score
}

/*1.

Adott egy vetélkedő kérdésbankja egy fájlban. A fálban az egy kérdéshez tartozó adatok két sorban helyezkednek el.
Első sorban a kérdés, a második sorban a válasz a pontszám és a téma szóközzel elválasztava. Olvasd be a fájl tartalmát
a memóriába, majd oldjátok meg a lenti feladatokat.


Írj egy metódust, melynek paramétere a téma és add vissza, az összes kérdést abban a témában. (Csak a kérdéseket)
        2. Írj egy metódust, ami random sorsol ki egy kérdést, és adja vissza annak összes adatát.
        3. Készíts egy metódust ami rendszerezi a kérdéseket témakörönként. Visszatér egy datszerkezetben amelyben
        témánként megtalálható az összes kérdés. // Map<String topic, List<String> questions>
        4. Az előző feladat segítségével határozd meg, hogy melyik téma kérdései érik a legtöbb pontot (összpontszám)!*/
