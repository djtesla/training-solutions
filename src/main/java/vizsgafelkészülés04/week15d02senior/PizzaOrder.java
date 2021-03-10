package vizsgafelkészülés04.week15d02senior;

import java.time.LocalTime;

public class PizzaOrder {
    private String buddyName;
    private String address;
    private LocalTime timeOfOrder;

    public PizzaOrder(String buddyName, String address, LocalTime timeOfOrder) {
        this.buddyName = buddyName;
        this.address = address;
        this.timeOfOrder = timeOfOrder;
    }

    public String getBuddyName() {
        return buddyName;
    }

    public String getAddress() {
        return address;
    }

    public LocalTime getTimeOfOrder() {
        return timeOfOrder;
    }

    @Override
    public String toString() {
        return
                "buddyName='" + buddyName + '\'' +
                ", address='" + address + '\'' +
                ", timeOfOrder=" + timeOfOrder;
    }
}
