public class CMDMakePayment implements Driver_Command {
    private ParkingTicket ticket;
    private PaymentMethod paymentMethod;
    private PaymentProcessor paymentProcessor;
    private double amount;

    public CMDMakePayment(ParkingTicket ticket, PaymentMethod paymentMethod, PaymentProcessor paymentProcessor, double amount) {
        this.ticket = ticket;
        this.paymentMethod = paymentMethod;
        this.paymentProcessor = paymentProcessor;
        this.amount = amount;
    }

    @Override
    public void execute() {
        if (paymentProcessor.processPayment(ticket, paymentMethod, amount)) {
            System.out.println("Payment of $" + amount + " processed successfully.");
        } else {
            System.out.println("Payment failed.");
        }
    }
}

