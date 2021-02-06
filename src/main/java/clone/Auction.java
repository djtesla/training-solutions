package clone;

import java.time.LocalDateTime;

public class Auction {

    private int price;
    private LocalDateTime dateTime;
    private User user;

    public Auction(int price, LocalDateTime dateTime, User user)  {
        this.price = price;
        this.dateTime = dateTime;
        this.user = user;
    }

    public Auction(Auction another) {
        price = another.price;
        dateTime = another.dateTime;
        user = new User(another.getUser().getName());
    }

    public int getPrice() {
        return price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "price=" + price +
                ", dateTime=" + dateTime +
                ", user=" + user;

    }
}
