public class ParkingTicket {
    private String ticketId;
    private String vehiclePlate;
    private long entryTime;
    private long exitTime;
    private double amount;
    private boolean isPaid;

    public ParkingTicket(String ticketId, String vehiclePlate, long entryTime) {
        this.ticketId = ticketId;
        this.vehiclePlate = vehiclePlate;
        this.entryTime = entryTime;
        this.isPaid = false;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public long getParkingDuration() {
        if (exitTime == 0) {
            return System.currentTimeMillis() - entryTime;
        }
        return exitTime - entryTime;
    }
}

