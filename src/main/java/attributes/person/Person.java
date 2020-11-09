package attributes.person;

public class Person {

    private String name;
    private String identificationCard;
    private Address address;

    public Person(String name, String identificationCard) {
        this.name = name;
        this.identificationCard = identificationCard;
        this.address = null;

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", identificationCard='" + identificationCard + '\'' +
                '}';
    }

    public void moveTo(Address address) {
        this.address = address;
    }

    public void correctData(String name, String identificationCard) {

        this.name = name;
        this.identificationCard = identificationCard;

    }

    public String getAddress() {

        return address.addressTostring();
    }

    public static void main(String[] args) {

        Person person = new Person("Lakatos Dzsézön", "A102");

        System.out.println(person);

        person.moveTo(new Address("Grúzia","Menyétfalva","Mindekipék sétány 7."));

        System.out.println(person.getAddress());
    }
}