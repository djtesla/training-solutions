package week12d01;

public class GradeRounder {


    public int[] roundGrades(int[] grades) {

        int i = 0;

        for (int grade : grades) {
            if (grade % 5 != 0) {

                grades[i] = getRoundedGrade(grade);

            }
            i++;
        }
        return grades;
    }


    public int getRoundedGrade(int grade) {

        int roundedGrade = grade;

        while (roundedGrade % 5 != 0) {
            roundedGrade++;
        }


        if ((roundedGrade - grade) > 2) {
            roundedGrade -= 5;
        }

        return roundedGrade;
    }


}



/*    Mai junior/medior feladat:
        Készíts egy GradeRounder osztályt, amiben van egy int[] roundGrades(int[] grades) metódus.
        A grades tömb pontszámokat tartalmaz 0 és 100 között. A feladat az, hogy kerekítsük a benne
        lévő számokat a következő szabály szerint: Ha a pontszám és az 5 következő többszöröse közötti
        különbség kisebb, mint 3, akkor kerekítsük fel a számot az 5 következő többszörösére. Fontos:
        a 40 pont alatti pontszámok elégtelenek, ezeket egyáltalán nem kell kerekíteni.
        Példa: a pontszám 84. 85 - 84 kevesebb mint 3, így felfelé kerekítünk.*/
