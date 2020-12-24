package isahasa.htmlmarchaller.isa;

public class HtmlText implements TextSource{


    private String plainText;


    public HtmlText(String plainText) {
        this.plainText = plainText;
    }

    @Override
    public String getPlainText() {

        return plainText;
    }
}
