package e1;

import e1.checkersCanWithdraw.AbstractCheckerCanWithdraw;
import e1.feeCalculators.AbstractFeeCalculator;

public class BankAccountImpl implements BankAccount {

    private CoreBankAccount base;
    private AbstractFeeCalculator feeCalculator;
    private AbstractCheckerCanWithdraw checkerCanWithdraw;

    public BankAccountImpl(CoreBankAccount base, AbstractFeeCalculator feeCalculator, AbstractCheckerCanWithdraw checkerCanWithdraw) {
        this.base = base;
        this.feeCalculator = feeCalculator;
        this.checkerCanWithdraw = checkerCanWithdraw;
    }

    public int getBalance() {
        return base.getBalance();
    }

    public void deposit(int amount) {
        base.deposit(amount);
    }

    public void withdraw(int amount) {
        if (!this.checkerCanWithdraw.canWithdraw(this.getBalance(), amount)) {
            throw new IllegalStateException();
        }
        this.base.withdraw(amount + this.feeCalculator.getFee(amount));
    }
}
