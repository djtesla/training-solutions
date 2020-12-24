package isahasa.htmlmarchaller.isa;

public class BoldHtmlText extends HtmlText {

    public BoldHtmlText(String plainText) {
        super(plainText);
    }

    @Override
    public String getPlainText() {

        return "<b>" + super.getPlainText() + "</b>";
    }
}
