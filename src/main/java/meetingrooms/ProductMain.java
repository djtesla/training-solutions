package meetingrooms;

public class ProductMain {
    public static void main(String[] args) {


        Product product1 = new Product("kenyér", "A1100");
        Product product2 = new Product("kalács", "A110");
        Product product3 = new Product("kenyér", "A1100");

        System.out.println(product1.areTheyEqual(product2));
        System.out.println(product1.areTheyEqual(product3));
        System.out.println(product1.areTheyEqual(product2));
        System.out.println(product1.areTheyEqual(product3));
    }
}
