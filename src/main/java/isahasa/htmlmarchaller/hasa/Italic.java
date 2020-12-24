package isahasa.htmlmarchaller.hasa;

public class Italic extends TextDecorator{

    public Italic(TextSource textSource) {
        super(textSource);
    }

    @Override
    public String getPlainText() {
        return "<i>" + textSource.getPlainText() + "</i>";
    }
}
