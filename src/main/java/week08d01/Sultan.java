package week08d01;

import java.util.ArrayList;
import java.util.List;

public class Sultan {

    private List<Door> doors = new ArrayList<>();

    public void add(Door door) {
        doors.add(door);
    }

    public List<Integer> openDoors() {

        for (Door door : doors) {
            for (int days = 1; days <= 100; days++) {
                changeNumberOfRotates(door, days);
            }
        }
        return getOpenDoors();

    }

    public void changeNumberOfRotates(Door door, int days) {

        if (door.getNumber() % days == 0) {
            door.setNumberOfRotates(door.getNumberOfRotates() + 1);
        }
    }


    public List<Integer> getOpenDoors () {

        List <Integer> openDoors = new ArrayList<>();

        for (Door door : doors) {
            if (door.getNumberOfRotates() % 2 != 0) {
                openDoors.add(door.getNumber());
            }
        }
        return openDoors;
    }
}




// % 2 = 0 - > nyitva

// 1  1
// 2  1 1
// 3  1 1
// 4  1 1 1
// 5  1  1
// 6  1 1 1 1
// 7  1
// 8  1 1 1
// 9  1 1
// 10 1 1 1



   /* Mai Senior feladat:
        A török szultán elhatározza, hogy a 100 nap múlva lévő születésnapján szabadon enged néhány rabot a börtönéből.
        A börtönben 100 cella van. Mindegyik cella zárva van. Ha egyet fordítunk a kulcson akkor nyitva lesz, ha még egyet
        akkor zárva ha hármat akkor ismét nyitva és így tovább.
        A szultán azt a parancsot adja, hogy az első nap mindegyik cellán fordítsanak egyet.  (Ekkor minden cella nyitva lesz)
        A második napon minden másodikon fordítsanak egyet, így minden második zárva lesz. A harmadik napon minden harmadikon
        fordítsanak egyet így a 3. cella zárva , de a 6. cella például nyitva lesz. A week08d01.Sultan osztályba írj egy metódust
        openDoors() néven,  aminek visszatérési értékéből kiderül, hogy mely ajtók lesznek nyitva a 100. napon! Az osztály szabadon bővíthető!*/
