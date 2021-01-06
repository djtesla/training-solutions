package exam02.cv;

public class Skill {

    private String description;
    private int level;


    public Skill(String description, int level) {
        this.description = description;
        this.level = level;
    }

    public String getName() {
        return description;
    }

    public int getLevel() {
        return level;
    }
}

/*  Egy önéletrajzot reprezentáló osztályt kell létrehozni, melyben van egy név, valamint skillek
        (hogy mihez ért az illető). A skill egy névvel és egy számmal (szint) rendelkezik, utóbbi 1 - 5 között.
        Az önéletrajz a Cv osztály pár metódussal, a skill a Skill osztály.
        A skillek megadása a nevével, valamint a szintjével történik, pl. programming (5).
        A findSkillLevelByName() a skill neve alapján visszaadja annak szintjét.*/
