package week02;

import java.util.Scanner;

public class Controller {

    public static final Scanner SCAN = new Scanner(System.in);
    public static String runMode = "Yes";
    public static String empty = "";

    Office office;


    public void readOffice() {

        Office office = new Office();

        this.office = office;

        System.out.println("Hány darab tárgyalót szeretnél rögzíteni?");

        int numOfRooms = SCAN.nextInt();


        for (int i = 0; i < numOfRooms; i++) {

            System.out.println(i + 1 +". Tárgyaló neve:" );

            String empty = SCAN.nextLine();
            String nameOfRoom = SCAN.nextLine();

            System.out.println(i + 1 +". Tárgyaló szélessége méterben:" );
            int widthtOfRoom = SCAN.nextInt();

            System.out.println(i + 1 +". Tárgyaló hosszúsága méterben:" );
            int lengthOfRoom = SCAN.nextInt();

            MeetingRoom meetingRoom = new MeetingRoom(nameOfRoom, lengthOfRoom, widthtOfRoom);

            this.office.addMeetingRoom(meetingRoom);

        }

    }

    public void readMenu () {

        System.out.println("1. Tárgyalók sorrendben");
        System.out.println("2. Tárgyalók visszafele sorrendben");
        System.out.println("3. Minden második tárgyaló");
        System.out.println("4. Területek");
        System.out.println("5. Keresés pontos név alapján");
        System.out.println("6. Keresés névtöredék alapján");
        System.out.println("7. Keresés terület alapján");
        System.out.println("8. Kilépés");

    }

    public void runMenu () {

        System.out.println();
        System.out.println("Hányadik menőpontot hajtsam végre?");
        int menuPoint = SCAN.nextInt();

        if (menuPoint == 1) {office.printNames();}
        if (menuPoint == 2) {office.printNamesReverse();}
        if (menuPoint == 3) {office.printEventNames();}
        if (menuPoint == 4) {office.printAreas();}

        if (menuPoint == 5) {
            System.out.println("Add meg a tárgyaló nevét:");
            empty = SCAN.nextLine();
            String roomName = SCAN.nextLine();
            office.printMeetingRoomsWithName(roomName);
        }

        if (menuPoint == 6) {
            System.out.println("Add meg a prefixet:");
            empty = SCAN.nextLine();
            String prefix = SCAN.nextLine();
            office.printMeetingRoomsContains(prefix);}

        if (menuPoint == 7) {
            System.out.println("Add meg a területet:");
            int area = SCAN.nextInt();
            office.printAreasLagerThan(area);}

        if (menuPoint == 8) {

            runMode = "No";

            System.out.println("Kiléptél cimbi. Gondolom kávé.");
        }
    }




    public static void main(String[] args) {

        Controller controller = new Controller();

        controller.readOffice();

        controller.readMenu();

        for (int i = 0; i <10; i++) {
         if (runMode == "Yes") {
             controller.runMenu();
         }
        }

    }


    }

