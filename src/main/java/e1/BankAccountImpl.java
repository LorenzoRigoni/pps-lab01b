package e1;

import e1.feeCalculators.AbstractFeeCalculator;

public class BankAccountImpl implements BankAccount {

    private CoreBankAccount base;
    private AbstractFeeCalculator feeCalculator;

    public BankAccountImpl(CoreBankAccount base, AbstractFeeCalculator feeCalculator) {
        this.base = base;
        this.feeCalculator = feeCalculator;
    }

    public int getBalance() {
        return base.getBalance();
    }

    public void deposit(int amount) {
        base.deposit(amount);
    }

    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        this.base.withdraw(amount + this.feeCalculator.getFee(amount));
    }
}
