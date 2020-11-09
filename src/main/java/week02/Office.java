package week02;

import java.util.ArrayList;
import java.util.List;

public class Office {

    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {

        meetingRooms.add(meetingRoom);

        }


    public void printNames() {

        String namestPrint = "";

        for (MeetingRoom meetingroom : meetingRooms) {

            namestPrint += meetingroom.getName() + " ";

        }
        System.out.println(namestPrint);
    }


    public void printNamesReverse() {

        String namesToPrint = "";

        for (int i = meetingRooms.size() - 1; i > -1; i--) {

            namesToPrint += meetingRooms.get(i).getName() + " ";

            }
        System.out.println(namesToPrint);

    }


    public void printEventNames() {

        String namesToPrint = "";

        for (int i = 1; i < meetingRooms.size(); i += 2) {

            namesToPrint += meetingRooms.get(i).getName() + " ";
        }
        System.out.println(namesToPrint);
    }

    public void printAreas() {
        int i = 1;
        for (MeetingRoom meetingRoom : meetingRooms) {

            System.out.println("A(z) " + i + ". tárgyaló neve: " + meetingRoom.getName());
            System.out.println("A(z) " + i + ". tárgyaló hossza (m): " + meetingRoom.getLength());
            System.out.println("A(z) " + i + ". tárgyaló szélessége (m): " + meetingRoom.getWidth());
            System.out.println("A(z) " + i + ". tárgyaló területe (m2): " + meetingRoom.getArea());
            System.out.println();

        }
    }

    public void printMeetingRoomsWithName(String roomName) {

        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getName().equals(roomName)) {
                System.out.println("Szélesség: " + meetingRoom.getWidth());
                System.out.println("Hosszúság: " + meetingRoom.getLength());
                System.out.println("Terület: " + meetingRoom.getArea());

            }

        }
    }

    public void printMeetingRoomsContains(String prefix) {

        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getName().toLowerCase().contains(prefix.toLowerCase())) {

                System.out.println("Név: " + meetingRoom.getName());
                System.out.println("Szélesség: " + meetingRoom.getWidth());
                System.out.println("Hosszúság: " + meetingRoom.getLength());
                System.out.println("Terület: " + meetingRoom.getArea());
                System.out.println();
            }
        }
    }

    public void printAreasLagerThan(int area) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getArea() > area) {
                System.out.println("Tárgyaló neve: " + meetingRoom.getName());
                System.out.println("Szélesség: " + meetingRoom.getWidth());
                System.out.println("Hosszúság: " + meetingRoom.getLength());
                System.out.println("Terület: " + meetingRoom.getArea());
                System.out.println();


            }

        }
    }
}