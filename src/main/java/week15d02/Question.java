package week15d02;

public class Question {

    private String title;
    private String answer;
    private int score;
    private String subject;

    public Question(String title, String answer, int score, String subject) {
        this.title = title;
        this.answer = answer;
        this.score = score;
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public String getAnswer() {
        return answer;
    }

    public int getScore() {
        return score;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "title=" + title + ", answer=" + answer + ", score=" + score + ", subject=" + subject;
    }
}