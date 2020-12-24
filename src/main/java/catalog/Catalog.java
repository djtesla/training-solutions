package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    public List<CatalogItem> catalogItems = new ArrayList<>();


    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }


    public void deleteItemByRegistrationNumber(String registrationNumber) {

        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.getRegistrationNumber().equals(registrationNumber)) {
                catalogItems.remove(catalogItem);
                return;
            }
        }


    }


    public List<CatalogItem> getAudioLibraryItems() {

        List<CatalogItem> audioLibraryItems = new ArrayList<>();

        for (CatalogItem catalogItem : catalogItems) {

            if (catalogItem.hasAudioFeature()) {
                audioLibraryItems.add(catalogItem);
            }
        }

        return audioLibraryItems;
    }


    public List<CatalogItem> getPrintedLibraryItems() {

        List<CatalogItem> printedLibraryItems = new ArrayList<>();

        for (CatalogItem catalogItem : catalogItems) {

            if (catalogItem.hasPrintedFeature()) {
                printedLibraryItems.add(catalogItem);
            }
        }

        return printedLibraryItems;
    }


    public int getAllPageNumber() {

        int sum = 0;

        for (CatalogItem catalogItem : catalogItems) {

            if (catalogItem.hasPrintedFeature()) {
                sum += catalogItem.numberOfPagesAtOneItem();
            }
        }
        return sum;
    }


    public int getFullLength() {

        int sum = 0;

        for (CatalogItem catalogItem : catalogItems) {

            if (catalogItem.hasAudioFeature()) {
                sum += catalogItem.fullLengthAtOneItem();
            }
        }
        return sum;
    }



    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {

        List<CatalogItem> selectedItems = new ArrayList<>();

        for (CatalogItem catalogItem : catalogItems) {

            if (searchCriteria.hasTitle() && catalogItem.getTitles().contains(searchCriteria.getTitle())) {
                selectedItems.add(catalogItem);
                continue;
            }

            if (searchCriteria.hasContributor() && catalogItem.getContributors().contains(searchCriteria.getContributor())) {
                selectedItems.add(catalogItem);
                continue;
            }

            if (searchCriteria.hasTitle() && catalogItem.getTitles().contains(searchCriteria.getTitle()) &&
                    searchCriteria.hasContributor() && catalogItem.getContributors().contains(searchCriteria.getContributor())) {
                selectedItems.add(catalogItem);
                continue;
            }
        }

        return selectedItems;
    }




    public double averagePageNumberOver(int page) {

        int sum = 0;
        int i = 0;


        if (page <= 0) {
            throw new IllegalArgumentException("Page number must be positive");
        }

        for (CatalogItem catalogItem : catalogItems) {

            if (catalogItem.hasPrintedFeature() && catalogItem.numberOfPagesAtOneItem() > page) {
                sum+=catalogItem.numberOfPagesAtOneItem();
                i++;
            }
        }

        if (sum == 0) {
            throw new IllegalArgumentException("No page");
        }

        return (double) sum / i;
    }


}
