package gyakorlás.vizsga2felkészülés;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void testCreatedAfter () {



    Account account = new Account(LocalDateTime.of(2020,11, 11, 10, 11));
        System.out.println(account.createdAfter(LocalDateTime.of(2019, 11, 11, 11, 11)));
    }


}