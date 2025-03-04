package e1;

import e1.checkersCanWithdraw.OverdraftCheckerCanWithdraw;
import e1.feeCalculators.NoFeeCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoldBankAccountTest extends BankAccountTest {
    private static final int DEPOSIT_AMOUNT = 1000;
    private static final int WITHDRAW_AMOUNT = 100;
    private static final int OVERDRAFT = 500;
    private static final int WITHDRAW_MORE_THAN_AVAILABLE = (DEPOSIT_AMOUNT + OVERDRAFT) * 2;

    @BeforeEach
    void beforeEach() {
        this.account = new BankAccountImpl(new CoreBankAccount(), new NoFeeCalculator(), new OverdraftCheckerCanWithdraw());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(WITHDRAW_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT - WITHDRAW_AMOUNT, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(WITHDRAW_MORE_THAN_AVAILABLE));
    }
}
