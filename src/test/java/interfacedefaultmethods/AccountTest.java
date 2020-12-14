package interfacedefaultmethods;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void testCreateAfter() {

        Account account = new Account(LocalDateTime.of(2018,1,1,10,0));
        boolean result = account.createdAfter(LocalDateTime.of(2018,1,1,11,0));

        System.out.println(result);

        assertFalse(account.createdAfter(LocalDateTime.of(2018,1,1,11,0)));


    }

}