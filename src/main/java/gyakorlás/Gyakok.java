package gyakorlás;

import java.util.Arrays;

public class Gyakok {

    private EnumGyak enumGyak;

    public Gyakok(EnumGyak enumGyak) {
        this.enumGyak = enumGyak;
    }

    public EnumGyak getEnumGyak() {
        return enumGyak;
    }

    private int age;

    public int getAge() {
        return age;
    }

    public void count () {

    int [][] tombs = new int[2][];
    tombs[0] = new int[3];
    tombs[1] = new int[2];
    tombs[2] = new int[1];


    for (int i = 0; i < tombs.length; i++) {

        for (int j = 0; j < tombs[i].length; j ++) {

            tombs[i][j] = 1;
                }

        System.out.print(Arrays.toString(tombs[i]));
        }
    }

    public String getTypeOfDayWithSwitchStatement(String dayOfWeekArg){
        String typeOfDay;
        switch(dayOfWeekArg){
            case "Monday":
                typeOfDay="Start of the work week";
                break;
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
                typeOfDay="Midweek";
                break;
            case "Friday":
                typeOfDay="End of work week";
                break;
            case "Saturday":
            case "Sunday":
                typeOfDay="Weekend";
                break;
            default:
                throw new IllegalArgumentException("Unknown day");
        }

        return typeOfDay;

    }
}
