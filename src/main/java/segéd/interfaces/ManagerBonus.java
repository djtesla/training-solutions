package segéd.interfaces;

public class ManagerBonus implements BonusCalculator {

    @Override
    public double getBonus(int salary) {
        return salary * 2.2;
    }
}
