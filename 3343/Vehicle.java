public class Vehicle {
    private String vehicleId;
    private VehicleType vehicleType;
    private String vehiclePlate;
    private String vehicleColor;
    private String vehicleModel;
    private String vehicleYear;
    private String vehicleMake;
    private String vehicleOwner;

    public Vehicle(String vehicleId, VehicleType vehicleType, String vehiclePlate, String vehicleColor, String vehicleModel, String vehicleYear, String vehicleMake, String vehicleOwner) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.vehiclePlate = vehiclePlate;
        this.vehicleColor = vehicleColor;
        this.vehicleModel = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.vehicleMake = vehicleMake;
        this.vehicleOwner = vehicleOwner;
    }

    // Getters
    public String getVehicleId() {
        return vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehicleYear() {
        return vehicleYear;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public String getVehicleOwner() {
        return vehicleOwner;
    }
}