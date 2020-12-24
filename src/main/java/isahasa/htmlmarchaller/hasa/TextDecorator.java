package isahasa.htmlmarchaller.hasa;

public abstract class TextDecorator implements TextSource{

    protected TextSource textSource;

    public TextDecorator(TextSource textSource) {
        this.textSource = textSource;
    }
}
