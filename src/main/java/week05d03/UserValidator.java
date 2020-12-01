package week05d03;

import java.util.List;

public class UserValidator {



    public boolean validate (List<User> users) {

        for (User user: users) {
            if (isEmpty(user.getName())) {
                throw new IllegalArgumentException("user name cannot be empty!");
            } else if (user.getAge() < 0 || user.getAge() > 120) {
                throw new IllegalArgumentException("age must be between 0 and 120!");
            }
        }
        return true;
    }


    private boolean isEmpty(String name) {
        return name == null || name.isBlank();
    }
}


 /*   A Senior csoport mai feladata:
        Készíts egy osztályt UserValidator néven, mely rendelkezik egy validate nevű metódussal.
        A metódus User objektumok listáját várja és a feladata az, hogy leellenőrizze, hogy az
        User name attribútuma nem üres és az User age attribútuma nem negatív és nem nagyobb, mint 120!
        Ha találunk egy nem megfelelő objektumot, akkor dobjunk el egy InvalidArgumentException kivételt,
        mely tartalmaz egy hibaüzenetet a validációs hiba okával! Bónusz feladat: készítsünk teszteseteket is,
        melyekben ellenőrizzük a helyes működést! (edited) */
