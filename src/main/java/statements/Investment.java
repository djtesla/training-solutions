package statements;

public class Investment {
    private double cost = 0.3; // befektetés összege
    private int fund; // tőke
    private int interestRate; //kamatláb
    private boolean active;

    public void setActive(boolean active) {
        this.active = this.active == true ? false : false ;
    }

    public Investment(int fund, int interestRate) {
        this.fund = fund;
        this.interestRate = interestRate;
        active = true;
    }

    public int getFund() {
        return fund;
    }

    public double getYield(int days) {
        return fund * interestRate/100 / 365 * days;
    }

    public double close(int days) {
        double payOut = active ? (getFund() + getYield(days)) * (1 - cost / 100) : 0;
        active = false;
        return payOut;
    }
}
