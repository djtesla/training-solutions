package classsctructureconstructors;

public class StoreMain {
    public static void main(String[] args) {
        Store store = new Store("kenyér");
        Store anotherStore = new Store("kalács");

        store.store(2);
        anotherStore.store(5);

        System.out.println("Product: " + store.getProduct() + ", stock: " + store.getStock());
        System.out.println("Product: " + anotherStore.getProduct() + ", stock: " + anotherStore.getStock());

        store.dispatch(1);
        anotherStore.dispatch(4);


        System.out.println("Product: " + store.getProduct() + ", stock: " + store.getStock());
        System.out.println("Product: " + anotherStore.getProduct() + ", stock: " + anotherStore.getStock());
    }
}
