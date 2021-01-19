package week12d02;

import java.util.ArrayList;
import java.util.List;

public class Street {

    List<Site> sites = new ArrayList<>();


    public void sellSite(Site site) {
        sites.add(site);
    }

    public int getLastSiteNumber() {

        int[] numbers = new int[sites.size()];

        int countOdd = 1;
        int countEven = 2;

        for (int i = 0; i < sites.size(); i++) {

            if (sites.get(i).getSide() == 0) {
                numbers[i] = countEven;
                countEven += 2;
            } else {
                numbers[i] = countOdd;
                countOdd += 2;
            }
        }
        return numbers[numbers.length - 1];
    }



    public List<FenceStat> getFenceStats() {

        List<FenceStat> fenceStats = new ArrayList<>();

        for (Fence fence : Fence.values()) {
            fenceStats.add(new FenceStat(fence, 0));
        }

        for (int i = 0; i < fenceStats.size(); i++) {

            for (Site site: sites) {
                if (site.getFence() == fenceStats.get(i).getFence()) {
                    fenceStats.get(i).setNumber();
                }
            }
        }
        return  fenceStats;
    }



    @Override
    public String toString() {
        return "Street{" +
                "sites=" + sites +
                '}';
    }
}



/*    Készítsd el a Site (telek) nevű osztályt. Egy telek jellemzői, páros vagy páratlan oldalon található,
        (0 = páros oldal 1 = páratlan oldal), a telek hossza méterben. Illetve egy Fence enum, ami a kerítés állapotát írja le.
        A kerités állapota lehet, PERFECT, NEED_UPGRADE, NO_FENCE. (konstruktor, getterek)
        ​
        Készítsd el a Street neű osztályt, melyben eladott telkek listája található. Kezdetben ez egy üres lista.
        Készíts egy sellSite(Site site) metódust, ami egy telek eladását reprezentálja, vagyis hozzádunk egy telket a listához.
        ​
        Határozd meg az utoljára eladott telek (lista utolsó eleme) házszámát, ha tudjuk, hogy a telkeket a két oldalon egymás után adták el!
        (páros oldalon kettőtől, páratlan oldalon 1-től indul a számozás)
        pl:
        0 10 PERFECT
        0 7 NEED_UPGRADE
        1 12 NEED_UPGRADE
        0 9 PERFECT
        0 11 NO_FENCE
        1 13 PERFECT
        A példában a házszámok rendre: 2,4,1,6,8,3
        ​
        Készíts statisztikát, ami a kerítés állapota alapján visszaadja, hogy mennyi telket adtak el kerítésfajtánként!
        (Egy metódus legyen, a visszatérési értéket ti döntitek el, de abból legyen egyértelmű, hogy melyikből mennyit adtak el.)*/
