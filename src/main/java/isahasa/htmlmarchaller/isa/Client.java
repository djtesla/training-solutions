package isahasa.htmlmarchaller.isa;

public class Client {

    private Channel channel;

    public Client(Channel channel) {
        this.channel = channel;
    }

    public void writeToChannel(TextSource textSource) {

       channel.writeByte(textSource.getPlainText().getBytes());
    }
}
