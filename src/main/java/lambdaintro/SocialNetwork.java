package lambdaintro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SocialNetwork {

    private List<Member> members;

    public SocialNetwork(List<Member> members) {
        this.members = members;
    }

    public List<Member> findMembersBy(Predicate<Member> condition) {
        List<Member> sorted = new ArrayList<>();
        for (Member member : members) {
            if (condition.test(member)) {
                sorted.add(member);
            }
        }
        return sorted;
    }


    public void applyToSelectedMembers(Predicate<Member> predicate, Consumer<Member> consumer) {
        for (Member member : members) {
            if (predicate.test(member)) {
                consumer.accept(member);
            }
        }
    }


    public  <T> List<T>  transformMembers(Function<Member, T> function ) {
        List<T> transformed = new ArrayList<>();
        for (Member member: members) {
            transformed.add(function.apply(member));
        }
        return transformed;
    }




    public static void main(String[] args) {
        SocialNetwork socialNetwork = new SocialNetwork(Arrays.asList(
                new Member("John Doe", Arrays.asList("Java", "OOP"), Gender.MALE),
                new Member("Jane Doe", Arrays.asList(".NET", "OOP"), Gender.FEMALE),
                new Member("James Doe", Arrays.asList("Python", "Java", "OOP"), Gender.MALE),
                new Member("Janet Doe", Arrays.asList("JavaScript", "scripting"), Gender.MALE)
        ));

        System.out.println(socialNetwork.findMembersBy(member -> member.getSkills().contains("Java")));

        socialNetwork.applyToSelectedMembers(
                member -> member.getGender() == Gender.MALE && member.getSkills().contains("Java"),
                member -> System.out.println("Hello Java speaker " + member.getName()+"!")
        );

        socialNetwork.transformMembers(member -> member.getSkills().add("New"));

        //Transform!
        List<String> names = socialNetwork.transformMembers(Member::getName);
    }


}
