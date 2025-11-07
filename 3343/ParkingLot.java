public class ParkingLot {
    private static ParkingLot instance;
    private ParkingSpot[][] spots;
    private int rows;
    private int cols;

    // Private constructor to prevent instantiation
    private ParkingLot(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.spots = new ParkingSpot[rows][cols];
        initializeSpots();
    }

    // Singleton getInstance method
    public static ParkingLot getInstance(int rows, int cols) {
        if (instance == null) {
            instance = new ParkingLot(rows, cols);
        }
        return instance;
    }

    // Overloaded method to get existing instance
    public static ParkingLot getInstance() {
        if (instance == null) {
            throw new IllegalStateException("ParkingLot not initialized. Call getInstance(rows, cols) first.");
        }
        return instance;
    }

    // Initialize all parking spots
    private void initializeSpots() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String spotId = generateSpotId(i, j);
                spots[i][j] = new ParkingSpot(spotId, ParkingSpotType.CAR, true, null, null, null, null, null, null);
            }
        }
    }

    // Generate spot ID based on position (e.g., "A1", "B3")
    private String generateSpotId(int row, int col) {
        return String.valueOf((char)('A' + row)) + (col + 1);
    }

    // Check if a spot is available
    public boolean isSpotAvailable(int row, int col) {
        if (isValidPosition(row, col)) {
            return spots[row][col].isAvailable();
        }
        return false;
    }

    // Reserve a parking spot
    public boolean reserveSpot(int row, int col, Vehicle vehicle) {
        if (isValidPosition(row, col) && isSpotAvailable(row, col)) {
            ParkingSpot spot = spots[row][col];
            spot.setAvailable(false);
            spot.setVehicleId(vehicle.getVehicleId());
            spot.setVehiclePlate(vehicle.getVehiclePlate());
            spot.setVehicleColor(vehicle.getVehicleColor());
            spot.setVehicleModel(vehicle.getVehicleModel());
            spot.setVehicleYear(vehicle.getVehicleYear());
            spot.setVehicleMake(vehicle.getVehicleMake());
            return true;
        }
        return false;
    }

    // Free a parking spot
    public boolean freeSpot(int row, int col) {
        if (isValidPosition(row, col)) {
            ParkingSpot spot = spots[row][col];
            spot.setAvailable(true);
            spot.setVehicleId(null);
            spot.setVehiclePlate(null);
            spot.setVehicleColor(null);
            spot.setVehicleModel(null);
            spot.setVehicleYear(null);
            spot.setVehicleMake(null);
            return true;
        }
        return false;
    }

    // Find first available spot
    public int[] findAvailableSpot() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (spots[i][j].isAvailable()) {
                    return new int[]{i, j};
                }
            }
        }
        return null; // No available spots
    }

    // Check if position is valid
    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    // Get a specific spot
    public ParkingSpot getSpot(int row, int col) {
        if (isValidPosition(row, col)) {
            return spots[row][col];
        }
        return null;
    }

    // Display parking lot status (visual representation)
    public void displayParkingLot() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (spots[i][j].isAvailable()) {
                    System.out.print("[ ] ");
                } else {
                    System.out.print("[x] ");
                }
            }
            System.out.println();
        }
    }

    // Get dimensions
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}

