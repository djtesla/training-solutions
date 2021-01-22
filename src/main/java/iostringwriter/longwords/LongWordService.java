package iostringwriter.longwords;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {


    public void write(Writer writer, List<String> elements) {

        try {
            for (String element : elements) {
                String line = element + String.valueOf(element.length());
                writer.write(line + "\n");
            }


        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }


    public String writeWithStringWriter(List<String> words) {

        StringWriter sw = new StringWriter();

        write(sw, words);

        return sw.toString();
    }


}







/*    Hosszú szavak
    Az első feladatban hosszú szavakat kell kezelned StringWriter segítségével.
        Írj egy metódust, ami egy Writer-t és egy listát kap paraméterül, és minden lista beli elem után írja a szó hosszát!
        Majd írj egy metódust, ami csak egy listát vár, és az előzőleg megírt metódust használja a paraéterül kapott listával
        és egy példányosított StringWriter-rel!*/
