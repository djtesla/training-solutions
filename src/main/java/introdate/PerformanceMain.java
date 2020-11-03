package introdate;

public class PerformanceMain {
    public static void main(String[] args) {
        Performance performance = new Performance("Queen", 1986, 06, 02, 18, 00, 20, 00);
        System.out.println(performance.getInfo());
    }
}
