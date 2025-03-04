package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    protected BankAccount account;
    private static final int INITIAL_DEPOSIT = 0;
    private static final int DEPOSIT_AMOUNT = 1000;

    @Test
    public void testInitiallyEmpty() {
        assertEquals(INITIAL_DEPOSIT, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, this.account.getBalance());
    }

}
