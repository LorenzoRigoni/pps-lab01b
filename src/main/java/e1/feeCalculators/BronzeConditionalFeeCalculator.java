package e1.feeCalculators;

public class BronzeConditionalFeeCalculator extends AbstractFeeCalculator {
    private static final int MINIMUM_FEE = 0;
    private static final int MAXIMUM_FEE = 1;

    @Override
    public int getFee(int amount) {
        return amount < 100 ? MINIMUM_FEE : MAXIMUM_FEE;
    }
}
