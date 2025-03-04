package e1;

import e1.feeCalculators.NoFeeCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoldBankAccountTest extends BankAccountTest {
    @BeforeEach
    void beforeEach() {
        this.account = new BankAccountImpl(new CoreBankAccount(), new NoFeeCalculator());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(800, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1600));
    }
}
