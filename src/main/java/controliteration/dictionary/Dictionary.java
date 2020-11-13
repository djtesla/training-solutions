package controliteration.dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dictionary {

    private List<DictionaryItem> dictionaryItems = new ArrayList<>();

    public List<DictionaryItem> getDictionaryItems() {
        return dictionaryItems;
    }

    @Override
    public String toString() {
        return
                dictionaryItems.toString();
    }

    public void addItem (String word, List<String> translations) {

        boolean b = false;
        for (DictionaryItem dictionaryItem : dictionaryItems) {

            if (dictionaryItem.getWord().equals(word)) {
                dictionaryItem.addTranslations(translations);
                b = true;
            }

            }
        if (!b) {
            dictionaryItems.add(new DictionaryItem(word, translations));
        }
    }

    public List<String> findTranslations(String word) {

        for (DictionaryItem dictionaryItem : dictionaryItems) {

            if (dictionaryItem.getWord() == word) {

                return dictionaryItem.getTranslations();
            }
        }
    return Arrays.asList();
    }


    
    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();

        dictionary.addItem("pull", Arrays.asList("húzás","rántás","evezés"));
        dictionary.addItem("take", Arrays.asList("visz","vesz","fog"));
        dictionary.addItem("make", Arrays.asList("okoz","rábír"));

        System.out.println(dictionary);

        System.out.println(dictionary.findTranslations("pull"));

        dictionary.addItem("pull", Arrays.asList("húzás","rántás","evezés", "von", "tép", "húz"));

        System.out.println(dictionary.findTranslations("pull"));

    }

}
