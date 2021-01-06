package exam02.cv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cv {

    private String name;
    private List<Skill> skills = new ArrayList<>();


    public Cv(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return skills;
    }


    public void addSkills(String... description) {

        //cv1.addSkills("programming (5)", "oo design (2)");


        for (String element : description) {
            int startOfLevel = element.indexOf('(');
            String name = element.substring(0, startOfLevel - 1).trim();
            int level = Integer.parseInt(element.substring(startOfLevel + 1, startOfLevel + 2));
            skills.add(new Skill(name, level));
        }
    }


    public int findSkillLevelByName(String name) {

        if (skills.size() == 0 || skills == null) {
            throw new SkillNotFoundException("Skill list is null or empty!");
        }

        for (int i = 0; i < skills.size(); i++) {
            if (skills.get(i).getName().equals(name)) {
                return skills.get(i).getLevel();
            }
        }

        return 0;
    }

}



/*    Egy önéletrajzot reprezentáló osztályt kell létrehozni, melyben van egy név, valamint skillek
        (hogy mihez ért az illető). A skill egy névvel és egy számmal (szint) rendelkezik, utóbbi 1 - 5 között.
        Az önéletrajz a Cv osztály pár metódussal, a skill a Skill osztály.
        A skillek megadása a nevével, valamint a szintjével történik, pl. programming (5).
        A findSkillLevelByName() a skill neve alapján visszaadja annak szintjét.*/


