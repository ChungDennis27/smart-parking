public class HourlyBill implements BillingStrategy {
    private double ratePerHour;

    public HourlyBill(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculateBill(long durationInMillis) {
        double hours = durationInMillis / (1000.0 * 60 * 60);
        return Math.ceil(hours) * ratePerHour; // Round up to nearest hour
    }

    public double getRatePerHour() {
        return ratePerHour;
    }
}

