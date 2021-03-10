package week16d01;

import java.time.LocalDateTime;

public class CanoeRental implements Comparable<CanoeRental> {

    private String name;
    private CanoeType canoeType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public CanoeRental(String name, CanoeType canoeType, LocalDateTime startTime) {
        this.name = name;
        this.canoeType = canoeType;
        this.startTime = startTime;
    }

    public CanoeRental(CanoeRental another) {
        this.name = another.name;
        this.canoeType = another.canoeType;
        this.startTime = another.startTime;
        this.endTime = another.endTime;
    }

    public String getName() {
        return name;
    }

    public CanoeType getCanoeType() {
        return canoeType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }


    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }


    public boolean isClosed() {
        return endTime != null;
    }


    public double calculateRentalSum() {
        if (endTime != null) {
            int numberOfHoursStarted = numberOfHoursStarted(endTime);
            return calculatePriceOfRental(canoeType, numberOfHoursStarted);
        } else {
            throw new IllegalArgumentException("The rental has no endtime");
        }
    }

    public int numberOfHoursStarted(LocalDateTime endTime) {
        int hoursPassed = endTime.getHour() - startTime.getHour();
        int minutesDifference = endTime.getMinute() - startTime.getMinute();
        if (minutesDifference < 0) {
            hoursPassed--;
        }
        return hoursPassed;
    }

    private double calculatePriceOfRental(CanoeType canoeType, int numberOfHoursStarted) {
        return canoeType.getMultiplier() * numberOfHoursStarted * 5000;
    }


    @Override
    public int compareTo(CanoeRental anotherCanoeRental) {
        return startTime.compareTo(anotherCanoeRental.startTime);
    }
}
