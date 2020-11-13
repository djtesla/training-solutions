package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class DictionaryItem {

    private String word;
    private List<String> translations = new ArrayList<>();

    @Override
    public String toString() {
        return
                word ;
    }

    public DictionaryItem(String word, List<String> translations) {
        this.word = word;
        this.translations = translations;
    }

    public String getWord() {
        return word;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void addTranslations(List<String> newTranslations) {
        for (String newTranslation: newTranslations) {
            if (!translations.contains(newTranslation)) {
                translations.add(newTranslation);
            }
        }
    }

}


