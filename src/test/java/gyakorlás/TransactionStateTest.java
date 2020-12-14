package gyakorlás;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionStateTest {

    @Test
    public void testIsCompleted () {

        HasTransactionState hasTransactionState = TransactionState.PENDING;

        assertFalse(hasTransactionState.isCompleted());

    }

}