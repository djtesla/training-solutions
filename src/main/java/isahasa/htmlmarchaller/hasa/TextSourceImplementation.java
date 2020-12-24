package isahasa.htmlmarchaller.hasa;


public class TextSourceImplementation implements TextSource {

    private String getPlainTextReturnValue;

    public TextSourceImplementation(String getPlainTextReturnValue) {
        this.getPlainTextReturnValue = getPlainTextReturnValue;
    }

    @Override
    public String getPlainText() {
        return getPlainTextReturnValue;
    }
}