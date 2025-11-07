import java.util.ArrayList;
import java.util.List;

public class Driver {
    private String driverId;
    private String name;
    private String phoneNumber;
    private MembershipType membershipType;
    private List<Vehicle> registeredVehicles;

    public Driver(String driverId, String name, String phoneNumber, MembershipType membershipType) {
        this.driverId = driverId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.membershipType = membershipType;
        this.registeredVehicles = new ArrayList<>();
    }

    public void registerVehicle(Vehicle vehicle) {
        registeredVehicles.add(vehicle);
    }

    public String getDriverId() {
        return driverId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public List<Vehicle> getRegisteredVehicles() {
        return registeredVehicles;
    }

    public Vehicle findVehicleByPlate(String plate) {
        for (Vehicle vehicle : registeredVehicles) {
            if (vehicle.getVehiclePlate().equals(plate)) {
                return vehicle;
            }
        }
        return null;
    }
}