import java.util.HashMap;
import java.util.Map;

public class ParkingLotManager {
    private ParkingLot parkingLot;
    private Map<String, ParkingTicket> vehicleTickets; // vehiclePlate -> ticket
    private Map<String, int[]> vehicleSpots; // vehiclePlate -> [row, col]

    public ParkingLotManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.vehicleTickets = new HashMap<>();
        this.vehicleSpots = new HashMap<>();
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        int[] spot = parkingLot.findAvailableSpot();
        if (spot == null) {
            return null; // No available spots
        }

        if (parkingLot.reserveSpot(spot[0], spot[1], vehicle)) {
            ParkingTicket ticket = new ParkingTicket(
                generateTicketId(),
                vehicle.getVehiclePlate(),
                System.currentTimeMillis()
            );
            vehicleTickets.put(vehicle.getVehiclePlate(), ticket);
            vehicleSpots.put(vehicle.getVehiclePlate(), spot);
            return ticket;
        }
        return null;
    }

    public boolean exitVehicle(String vehiclePlate) {
        ParkingTicket ticket = vehicleTickets.get(vehiclePlate);
        if (ticket == null) {
            return false;
        }

        int[] spot = vehicleSpots.get(vehiclePlate);
        if (spot != null) {
            parkingLot.freeSpot(spot[0], spot[1]);
            vehicleSpots.remove(vehiclePlate);
        }
        vehicleTickets.remove(vehiclePlate);
        return true;
    }

    public ParkingTicket getTicket(String vehiclePlate) {
        return vehicleTickets.get(vehiclePlate);
    }

    public int[] getVehicleSpot(String vehiclePlate) {
        return vehicleSpots.get(vehiclePlate);
    }

    public void displayParkingLot() {
        parkingLot.displayParkingLot();
    }

    private String generateTicketId() {
        return "TKT" + System.currentTimeMillis();
    }
}

