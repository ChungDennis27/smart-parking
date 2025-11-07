public class PercentageDiscount implements DiscountStrategy {
    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double originalAmount, Driver driver) {
        return originalAmount * (1 - percentage / 100.0);
    }

    public double getPercentage() {
        return percentage;
    }
}

