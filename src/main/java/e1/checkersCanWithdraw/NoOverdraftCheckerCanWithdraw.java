package e1.checkersCanWithdraw;

public class NoOverdraftCheckerCanWithdraw extends AbstractCheckerCanWithdraw {
    @Override
    public boolean canWithdraw(int balance, int amount) {
        return balance >= amount;
    }
}
