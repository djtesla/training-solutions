package week16d01;

import java.time.LocalDateTime;
import java.util.*;

public class CanoeOffice {

    List<CanoeRental> canoeRentalList = new ArrayList<>();


    public void addRental(CanoeRental canoeRental) {
        canoeRentalList.add(canoeRental);
    }


    public CanoeRental findRentalByName(String name) {
        for (CanoeRental canoeRental : canoeRentalList) {
            if (isActiveAndHasName(canoeRental, name)) {
                return canoeRental;
            }
        }
        throw new IllegalArgumentException("No active canoe rental found with given name");
    }


    private boolean isActiveAndHasName(CanoeRental canoeRental, String name) {
        return canoeRental.getEndTime() == null &&
                canoeRental.getName().equals(name);
    }


    public void closeRentalByName(String name, LocalDateTime endTime) {
        findRentalByName(name).setEndTime(endTime);
    }


    public double getRentalPriceByName(String name, LocalDateTime endTime) {
        CanoeRental closedRental = new CanoeRental(findRentalByName(name));
        closedRental.setEndTime(endTime);
        return closedRental.calculateRentalSum();
    }


    public List<CanoeRental> listClosedRentals() {
        List<CanoeRental> listOfClosedRentals = new ArrayList<>();
        for (CanoeRental canoeRental : canoeRentalList) {
            if (canoeRental.isClosed()) {
                listOfClosedRentals.add(canoeRental);
            }
        }
        Collections.sort(listOfClosedRentals);
        return  listOfClosedRentals;
    }



    public Map<CanoeType, Integer> countRentals() {
        Map<CanoeType, Integer> mapOfRentalsPerColour = new HashMap<>();
        for (CanoeRental canoeRental : canoeRentalList) {
            CanoeType canoeType = canoeRental.getCanoeType();
            if (mapOfRentalsPerColour.containsKey(canoeType)) {
                mapOfRentalsPerColour.put(canoeType, mapOfRentalsPerColour.get(canoeType)+1);
            } else {
                mapOfRentalsPerColour.put(canoeType, 1);
            }
        }
        return mapOfRentalsPerColour;
    }




}
