package e1;

import e1.checkersCanWithdraw.NoOverdraftCheckerCanWithdraw;
import e1.feeCalculators.BronzeConditionalFeeCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BronzeBankAccountTest extends BankAccountTest {
    @BeforeEach
    void beforeEach() {
        this.account = new BankAccountImpl(new CoreBankAccount(), new BronzeConditionalFeeCalculator(), new NoOverdraftCheckerCanWithdraw());
    }

    @Test
    public void testCanWithdrawNoFee() {
        this.account.deposit(1000);
        this.account.withdraw(50);
        assertEquals(950, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawWithFee() {
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(799, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }
}
