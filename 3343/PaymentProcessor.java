public class PaymentProcessor {
    public boolean processPayment(ParkingTicket ticket, PaymentMethod paymentMethod, double amount) {
        if (ticket == null) {
            System.out.println("Invalid ticket.");
            return false;
        }

        if (ticket.isPaid()) {
            System.out.println("Ticket already paid.");
            return false;
        }

        paymentMethod.pay(amount);
        ticket.setPaid(true);
        ticket.setAmount(amount);
        return true;
    }
}

