package e1.checkersCanWithdraw;

public class OverdraftCheckerCanWithdraw extends AbstractCheckerCanWithdraw {
    private static final int OVERDRAFT = -500;

    @Override
    public boolean canWithdraw(int balance, int amount) {
        return (balance - amount) >= OVERDRAFT;
    }
}
