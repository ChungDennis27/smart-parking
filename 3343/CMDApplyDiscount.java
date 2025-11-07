public class CMDApplyDiscount implements Staff_Command {
    private ParkingTicket ticket;
    private DiscountStrategy discountStrategy;
    private Driver driver;

    public CMDApplyDiscount(ParkingTicket ticket, DiscountStrategy discountStrategy, Driver driver) {
        this.ticket = ticket;
        this.discountStrategy = discountStrategy;
        this.driver = driver;
    }

    @Override
    public void execute() {
        if (ticket == null) {
            System.out.println("Invalid ticket.");
            return;
        }

        double originalAmount = ticket.getAmount();
        double discountedAmount = discountStrategy.applyDiscount(originalAmount, driver);
        ticket.setAmount(discountedAmount);
        System.out.println("Discount applied. Original: $" + originalAmount + ", Discounted: $" + discountedAmount);
    }
}

