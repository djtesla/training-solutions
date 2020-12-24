package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {

    private final List<String> composer;
    private final int length;
    private final List<String> performers;
    private final String title;


    public List<String> getContributors() {

        List<String> contributors = new ArrayList<>();

        if (!Validators.isEmpty(composer)) {
            contributors = new ArrayList<>(composer);
        }

        for (String element : performers) {
            if (!isIncluded(element, composer)) {
                contributors.add(element);
            }
        }
        return contributors;
    }


    public AudioFeatures(String title, int length, List<String> performers) {

        if (Validators.isBlank(title) ||
                Validators.isEmpty(performers) ||
                length < 0) {

            throw new IllegalArgumentException("invalid parameter!");
        }


        this.composer = new ArrayList<>();
        this.length = length;
        this.performers = performers;
        this.title = title;
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {

        if (Validators.isBlank(title) ||
                Validators.isEmpty(performers) ||
                length < 0) {

            throw new IllegalArgumentException("invalid parameter!");
        }

        this.composer = composer;
        this.length = length;
        this.performers = performers;
        this.title = title;
    }


    public int getLength() {
        return length;
    }


    public String getTitle() {
        return title;
    }


    static boolean isIncluded(String element, List<String> stringList) {

        for (String e : stringList) {
            if (element.equals(e)) {
                return true;
            }
        }
        return false;
    }


}


