public class CMDRegisterVehicle implements Driver_Command {
    private Driver driver;
    private Vehicle vehicle;
    private DriverManager driverManager;

    public CMDRegisterVehicle(Driver driver, Vehicle vehicle, DriverManager driverManager) {
        this.driver = driver;
        this.vehicle = vehicle;
        this.driverManager = driverManager;
    }

    @Override
    public void execute() {
        driver.registerVehicle(vehicle);
        driverManager.registerDriver(driver);
        System.out.println("Vehicle " + vehicle.getVehiclePlate() + " registered successfully for driver " + driver.getName());
    }
}

