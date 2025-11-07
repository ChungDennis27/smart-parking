public class DailyBill implements BillingStrategy {
    private double ratePerDay;

    public DailyBill(double ratePerDay) {
        this.ratePerDay = ratePerDay;
    }

    @Override
    public double calculateBill(long durationInMillis) {
        double days = durationInMillis / (1000.0 * 60 * 60 * 24.0);
        return Math.ceil(days) * ratePerDay; // Round up to nearest day
    }

    public double getRatePerDay() {
        return ratePerDay;
    }
}

