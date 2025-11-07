public class CMDPickupVehicle implements Driver_Command {
    private String vehiclePlate;
    private ParkingLotManager parkingLotManager;
    private TicketManage ticketManage;

    public CMDPickupVehicle(String vehiclePlate, ParkingLotManager parkingLotManager, TicketManage ticketManage) {
        this.vehiclePlate = vehiclePlate;
        this.parkingLotManager = parkingLotManager;
        this.ticketManage = ticketManage;
    }

    @Override
    public void execute() {
        ParkingTicket ticket = parkingLotManager.getTicket(vehiclePlate);
        if (ticket == null) {
            System.out.println("No ticket found for vehicle " + vehiclePlate);
            return;
        }

        if (!ticket.isPaid()) {
            System.out.println("Payment required before vehicle pickup.");
            return;
        }

        if (parkingLotManager.exitVehicle(vehiclePlate)) {
            ticket.setExitTime(System.currentTimeMillis());
            System.out.println("Vehicle " + vehiclePlate + " has exited successfully.");
        } else {
            System.out.println("Failed to exit vehicle " + vehiclePlate);
        }
    }
}

