public class Ticket {
    private String ticketId;
    private String eventName;
    private String eventDate;
    private String eventTime;
    private String eventLocation;
    private String eventDescription;
    private TicketStatus status;
    private PaymentMethod paymentMethod;
    private double price;

    public Ticket(String ticketId, String eventName, String eventDate, String eventTime, String eventLocation, String eventDescription, TicketStatus status, PaymentMethod paymentMethod, double price) {
        this.ticketId = ticketId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.price = price;
    }

    public void cancelTicket() {
        this.status = TicketStatus.CANCELLED;
    }

    public void confirmTicket() {
        this.status = TicketStatus.CONFIRMED;
    }

    public void payForTicket() {
        this.paymentMethod.pay(this.price);
    }
    public double getPrice() {
        return price;
    }

    public void printTicket() {
        System.out.println("Ticket ID: " + this.ticketId);
        System.out.println("Event Name: " + this.eventName);
        System.out.println("Event Date: " + this.eventDate);
        System.out.println("Event Time: " + this.eventTime);
        System.out.println("Event Location: " + this.eventLocation);
        System.out.println("Event Description: " + this.eventDescription);
        System.out.println("Status: " + this.status);
        System.out.println("Payment Method: " + this.paymentMethod);
        System.out.println("Price: " + this.price);
    }
    public void saveTicket() {
        // save the ticket to the database
    }
    public void deleteTicket() {
        // delete the ticket from the database
    }
    public void updateTicket() {
        // update the ticket in the database
    }
    public void getTicket() {
        // get the ticket from the database
    }
}       