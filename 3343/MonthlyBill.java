public class MonthlyBill implements BillingStrategy {
    private double ratePerMonth;

    public MonthlyBill(double ratePerMonth) {
        this.ratePerMonth = ratePerMonth;
    }

    @Override
    public double calculateBill(long durationInMillis) {
        double months = durationInMillis / (1000.0 * 60 * 60 * 24 * 30.0);
        return Math.ceil(months) * ratePerMonth; // Round up to nearest month
    }

    public double getRatePerMonth() {
        return ratePerMonth;
    }
}

