package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogItem {

    private List<Feature> features = new ArrayList<>();
    private final int price;
    private final String registrationNumber;



    public CatalogItem(String registrationNumber, int price, Feature... features) {
        this.features = Arrays.asList(features);
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public List<String> getContributors() {

        List<String> contributors = new ArrayList<>(features.get(0).getContributors());

        if (features.size() > 1) {
            for (int i = 1; i < features.size(); i++) {
                contributors = getUnionOfLists(contributors, features.get(i).getContributors());
            }
        }

        return contributors;
    }


    public List<String> getUnionOfLists(List<String> list1, List<String> list2) {

        List<String> contributors = new ArrayList<>(list1);

        for (String element : list2) {
            if (!AudioFeatures.isIncluded(element, list1)) {
                contributors.add(element);
            }
        }
        return contributors;
    }


    public List<String> getTitles() {

        List<String> titles = new ArrayList<>();

        for (Feature feature : features) {
            if (!titles.contains(feature.getTitle())) {
                titles.add(feature.getTitle());
            }
        }
        return titles;
    }


    public boolean hasAudioFeature() {

        for (Feature feature : features) {
            if (feature instanceof AudioFeatures) {
                return true;
            }
        }
        return false;
    }


    public boolean hasPrintedFeature() {

        for (Feature feature : features) {
            if (feature instanceof PrintedFeatures) {
                return true;
            }
        }
        return false;
    }


    public int numberOfPagesAtOneItem() {

        int sum = 0;

        for (Feature feature : features) {

            if (feature instanceof PrintedFeatures) {
                sum += ((PrintedFeatures) feature).getNumberOfPages();
            }
        }

        return sum;
    }


    public int fullLengthAtOneItem() {

        int sum = 0;

        for (Feature feature : features) {

            if (feature instanceof AudioFeatures) {
                sum += ((AudioFeatures) feature).getLength();
            }
        }

        return sum;
    }


    public List<Feature> getFeatures() {
        return features;
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}