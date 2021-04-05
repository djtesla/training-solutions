package lambdaintro;

import java.util.ArrayList;
import java.util.List;

public class Member {


    private String name;
    private List<String> skills;
    private Gender gender;
    private List<String> messages = new ArrayList<>();

    public Member(String name, List<String> skills, Gender gender) {
        this.name = name;
        this.skills = skills;
        this.gender = gender;
        this.messages = messages;
    }

    public void sendMessage(String message) {
        messages.add(message);
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public Gender getGender() {
        return gender;
    }

    public List<String> getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ", skills=" + skills +
                        ", gender=" + gender +
                        ", messages=" + messages;

    }
}
