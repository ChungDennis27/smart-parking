public class ParkingDiscount implements DiscountStrategy {
    private double fixedAmount;

    public ParkingDiscount(double fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    @Override
    public double applyDiscount(double originalAmount, Driver driver) {
        double discounted = originalAmount - fixedAmount;
        return Math.max(0, discounted); // Ensure non-negative
    }

    public double getFixedAmount() {
        return fixedAmount;
    }
}

