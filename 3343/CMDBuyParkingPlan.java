public class CMDBuyParkingPlan implements Staff_Command {
    private Driver driver;
    private BillingStrategy billingStrategy;
    private String planName;

    public CMDBuyParkingPlan(Driver driver, BillingStrategy billingStrategy, String planName) {
        this.driver = driver;
        this.billingStrategy = billingStrategy;
        this.planName = planName;
    }

    @Override
    public void execute() {
        System.out.println("Parking plan '" + planName + "' purchased for driver " + driver.getName());
        System.out.println("Plan details will be stored in driver profile.");
    }
}

