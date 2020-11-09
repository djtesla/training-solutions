package attributes.person;

public class Address {

    private String country;
    private String city;
    private String streetAndNumber;

    public Address(String country, String city, String streetAndNumber) {
        this.country = country;
        this.city = city;
        this.streetAndNumber = streetAndNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public String addressTostring() {

    return getCountry() + " / " + getCity() + ", " + getStreetAndNumber();

    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", streetAndNumber='" + streetAndNumber + '\'' +
                '}';
    }


    public void correctData(String country, String city, String streetAndNumber) {

        this.country = country;
        this.city = city;
        this.streetAndNumber = streetAndNumber;

    }

    public static void main(String[] args) {

        Address address = new Address("Madagaszkár","Majomfalva","Szulikáta utca 9.");

        System.out.println(address.addressTostring());
    }
}