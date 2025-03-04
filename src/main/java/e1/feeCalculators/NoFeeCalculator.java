package e1.feeCalculators;

public class NoFeeCalculator extends AbstractFeeCalculator {
    private static final int FEE = 0;

    @Override
    public int getFee(int amount) {
        return FEE;
    }
}
