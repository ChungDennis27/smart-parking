import java.util.HashMap;
import java.util.Map;

public class TicketManage {
    private Map<String, ParkingTicket> tickets;

    public TicketManage() {
        this.tickets = new HashMap<>();
    }

    public void createTicket(ParkingTicket ticket) {
        tickets.put(ticket.getTicketId(), ticket);
    }

    public ParkingTicket getTicket(String ticketId) {
        return tickets.get(ticketId);
    }

    public ParkingTicket getTicketByVehiclePlate(String vehiclePlate) {
        for (ParkingTicket ticket : tickets.values()) {
            if (ticket.getVehiclePlate().equals(vehiclePlate)) {
                return ticket;
            }
        }
        return null;
    }

    public void updateTicket(ParkingTicket ticket) {
        tickets.put(ticket.getTicketId(), ticket);
    }
}

