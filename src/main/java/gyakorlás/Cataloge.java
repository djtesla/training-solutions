package gyakorlás;

import catalog.Catalog;

import java.util.*;

public class Cataloge {

    private String name;
    private User user;

    public Cataloge (Cataloge another) {

        this.name = another.name;
        //this.user = new User(another.user.getName());
        this.user = new User(another.user);
    }


    public static void main(String[] args) {

       List<Integer> nums = List.of(1,2,3,4,5);
       //Collections.shuffle(nums);

        nums.add(2,5);


    }

}
