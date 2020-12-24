package catalog;

public class SearchCriteria {

    private String contributor;
    private String title;


    public static SearchCriteria createByBoth(String title, String contributor) {

        if (Validators.isBlank(title) || Validators.isBlank(contributor)) {
            throw new IllegalArgumentException("invalid parameter!");
        }
        return new SearchCriteria(contributor, title);
    }


    public static SearchCriteria createByContributor(String contributor) {


        if (Validators.isBlank(contributor)) {
            throw new IllegalArgumentException("invalid parameter!");
        }

        return new SearchCriteria(contributor, null);
    }


    public static SearchCriteria createByTitle(String title) {

        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("invalid parameter!");
        }
        return new SearchCriteria(null, title);
    }


    public SearchCriteria(String contributor, String title) {

        this.contributor = contributor;
        this.title = title;
    }


    public boolean hasContributor() {
        return !Validators.isBlank(contributor);
    }


    public boolean hasTitle() {
        return !Validators.isBlank(title);
    }



    public String getContributor() {
        return contributor;
    }


    public String getTitle() {
        return title;
    }


}
