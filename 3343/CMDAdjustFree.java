public class CMDAdjustFree implements Staff_Command {
    private ParkingTicket ticket;
    private double newAmount;

    public CMDAdjustFree(ParkingTicket ticket, double newAmount) {
        this.ticket = ticket;
        this.newAmount = newAmount;
    }

    @Override
    public void execute() {
        if (ticket == null) {
            System.out.println("Invalid ticket.");
            return;
        }

        double oldAmount = ticket.getAmount();
        ticket.setAmount(newAmount);
        System.out.println("Ticket amount adjusted from $" + oldAmount + " to $" + newAmount);
    }
}

