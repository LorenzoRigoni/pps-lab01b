package e1;

import e1.checkersCanWithdraw.NoOverdraftCheckerCanWithdraw;
import e1.feeCalculators.BronzeConditionalFeeCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BronzeBankAccountTest extends BankAccountTest {
    private static final int DEPOSIT_AMOUNT = 1000;
    private static final int WITHDRAW_NO_FEE_AMOUNT = 50;
    private static final int WITHDRAW_WITH_FEE_AMOUNT = 100;
    private static final int FEE = 1;
    private static final int WITHDRAW_MORE_THAN_AVAILABLE = DEPOSIT_AMOUNT * 2;

    @BeforeEach
    void beforeEach() {
        this.account = new BankAccountImpl(new CoreBankAccount(), new BronzeConditionalFeeCalculator(), new NoOverdraftCheckerCanWithdraw());
    }

    @Test
    public void testCanWithdrawNoFee() {
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(WITHDRAW_NO_FEE_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT - WITHDRAW_NO_FEE_AMOUNT, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawWithFee() {
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(WITHDRAW_WITH_FEE_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT - WITHDRAW_WITH_FEE_AMOUNT - FEE, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(WITHDRAW_MORE_THAN_AVAILABLE));
    }
}
