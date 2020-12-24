package catalog;

import java.util.ArrayList;
import java.util.List;

public class PrintedFeatures implements Feature {

    private List<String> authors;
    private int numberOfPages;
    private String title;


    @Override
    public List<String> getContributors() {
        return new ArrayList<>(authors);
    }


    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {

        if (Validators.isEmpty(authors) ||
                numberOfPages < 0) {
            throw new IllegalArgumentException("invalid parameter!");
        }

        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }

        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.title = title;
    }



    public int getNumberOfPages() {
        return numberOfPages;
    }



    public String getTitle() {
        return title;
    }


}
