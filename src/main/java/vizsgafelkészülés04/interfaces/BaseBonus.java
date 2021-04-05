package vizsgafelkészülés04.interfaces;

public class BaseBonus implements BonusCalculator{

    @Override
    public double getBonus(int salary) {
        return salary * 1.5;
    }
}
