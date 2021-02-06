package clone;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class AuctionTest {

    @Test
    public void cloneTest() {

        System.out.println(LocalDateTime.now());

        Auction au = new Auction(100, LocalDateTime.parse("2021-02-06T07:55:37"), new User("Csöpi"));

        Auction au2 = new Auction(au);

        au.getUser().setName("Big Daddy Laca");

        System.out.println(au);

        System.out.println(au2);
    }


}