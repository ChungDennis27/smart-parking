public interface TicketState {
    void handleState(ParkingTicket ticket);
    String getStateName();
}

class ActiveState implements TicketState {
    @Override
    public void handleState(ParkingTicket ticket) {
        System.out.println("Ticket is active. Vehicle is parked.");
    }

    @Override
    public String getStateName() {
        return "ACTIVE";
    }
}

class PaidState implements TicketState {
    @Override
    public void handleState(ParkingTicket ticket) {
        System.out.println("Ticket is paid. Ready to exit.");
    }

    @Override
    public String getStateName() {
        return "PAID";
    }
}

class CompletedState implements TicketState {
    @Override
    public void handleState(ParkingTicket ticket) {
        System.out.println("Ticket is completed. Vehicle has exited.");
    }

    @Override
    public String getStateName() {
        return "COMPLETED";
    }
}

