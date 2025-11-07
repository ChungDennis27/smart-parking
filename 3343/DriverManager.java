import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    private Map<String, Driver> drivers;
    private static DriverManager instance;

    private DriverManager() {
        this.drivers = new HashMap<>();
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.put(driver.getDriverId(), driver);
    }

    public Driver getDriver(String driverId) {
        return drivers.get(driverId);
    }

    public Driver findDriverByVehiclePlate(String plate) {
        for (Driver driver : drivers.values()) {
            Vehicle vehicle = driver.findVehicleByPlate(plate);
            if (vehicle != null) {
                return driver;
            }
        }
        return null;
    }
}

