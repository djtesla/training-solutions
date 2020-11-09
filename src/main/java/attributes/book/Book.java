package attributes.book;

public class Book {

    String title;
    private String name;

    public Book(String title) {
        this.title = title;
    }

    public void setTitle(String title) {

        this.title = title;

    }

    private String getTitle() {

        return this.title;
    }


    public static void main(String[] args) {

        Book book = new Book("Macskafogó");
        book.getTitle();
    }

}


