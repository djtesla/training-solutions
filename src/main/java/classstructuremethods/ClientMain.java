package classstructuremethods;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();
        client.setAddress("1186 Budapest Goroszló utca 13.");
        client.setName("Zámbó Ernő");
        client.setYear(1982);

        System.out.println(client.getName());
        System.out.println(client.getAddress());
        System.out.println(client.getYear());

        client.migrate("2220 Horthy 3.");

        System.out.println("Új lakcíme: " + client.getAddress());

            }

}
