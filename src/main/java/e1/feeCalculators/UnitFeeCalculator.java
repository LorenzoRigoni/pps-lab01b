package e1.feeCalculators;

public class UnitFeeCalculator extends AbstractFeeCalculator {
    private static final int FEE = 1;

    @Override
    public int getFee(int amount) {
        return FEE;
    }
}
