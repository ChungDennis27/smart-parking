public class ParkingSpot {
    private String parkingSpotId;
    private ParkingSpotType parkingSpotType;
    private boolean isAvailable;
    private String vehicleId;
    private String vehiclePlate;
    private String vehicleColor;
    private String vehicleModel;
    private String vehicleYear;
    private String vehicleMake;

    public ParkingSpot(String parkingSpotId, ParkingSpotType parkingSpotType, boolean isAvailable, 
                       String vehicleId, String vehiclePlate, String vehicleColor, 
                       String vehicleModel, String vehicleYear, String vehicleMake) {
        this.parkingSpotId = parkingSpotId;
        this.parkingSpotType = parkingSpotType;
        this.isAvailable = isAvailable;
        this.vehicleId = vehicleId;
        this.vehiclePlate = vehiclePlate;
        this.vehicleColor = vehicleColor;
        this.vehicleModel = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.vehicleMake = vehicleMake;
    }

    // Getters
    public String getParkingSpotId() {
        return parkingSpotId;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getVehicleId() {
        return vehicleId;
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

    // Setters
    public void setParkingSpotId(String parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public void setVehicleYear(String vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }
}