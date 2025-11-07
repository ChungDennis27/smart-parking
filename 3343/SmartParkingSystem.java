import java.util.Scanner;

public class SmartParkingSystem {
    private ParkingLotManager parkingLotManager;
    private TicketManage ticketManage;
    private PaymentProcessor paymentProcessor;
    private DriverManager driverManager;
    private Driver_Invoker driverInvoker;
    private Staff_Invoker staffInvoker;
    private BillingStrategy billingStrategy;
    private Scanner scanner;

    public SmartParkingSystem() {
        // Initialize parking lot (4x5 grid as per example)
        ParkingLot parkingLot = ParkingLot.getInstance(4, 5);
        this.parkingLotManager = new ParkingLotManager(parkingLot);
        this.ticketManage = new TicketManage();
        this.paymentProcessor = new PaymentProcessor();
        this.driverManager = DriverManager.getInstance();
        this.driverInvoker = new Driver_Invoker();
        this.staffInvoker = new Staff_Invoker();
        this.billingStrategy = new HourlyBill(5.0); // $5 per hour
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    carEnter();
                    break;
                case 2:
                    carExit();
                    break;
                case 3:
                    viewParkingLotStatus();
                    break;
                case 4:
                    System.out.println("Thank you for using Parking Lot Management System!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nParking Lot Management System");
        System.out.println("1. car enter");
        System.out.println("2. car exits");
        System.out.println("3. view parking lot status");
        System.out.println("4. quit");
        System.out.print("choose option ( 1-4 ) : ");
    }

    private int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void carEnter() {
        System.out.print("Enter Vehicle Number: ");
        String vehiclePlate = scanner.nextLine().trim().toUpperCase();

        if (vehiclePlate.isEmpty()) {
            System.out.println("Invalid vehicle number.");
            return;
        }

        // Check if vehicle already parked
        if (parkingLotManager.getTicket(vehiclePlate) != null) {
            System.out.println("Vehicle is already parked.");
            return;
        }

        // Get or create driver and vehicle
        Driver driver = driverManager.findDriverByVehiclePlate(vehiclePlate);
        Vehicle vehicle;

        if (driver == null) {
            // Create new driver and vehicle
            String driverId = "DRV" + System.currentTimeMillis();
            driver = new Driver(driverId, "Guest", "000-0000", MembershipType.REGULAR);
            
            String vehicleId = "V" + System.currentTimeMillis();
            vehicle = new Vehicle(vehicleId, VehicleType.CAR, vehiclePlate, "Unknown", "Unknown", "Unknown", "Unknown", "Guest");
            
            // Register vehicle using command
            CMDRegisterVehicle registerCmd = new CMDRegisterVehicle(driver, vehicle, driverManager);
            driverInvoker.executeCommand(registerCmd);
        } else {
            vehicle = driver.findVehicleByPlate(vehiclePlate);
            if (vehicle == null) {
                System.out.println("Vehicle not found for driver.");
                return;
            }
        }

        // Park the vehicle
        ParkingTicket ticket = parkingLotManager.parkVehicle(vehicle);
        if (ticket != null) {
            ticketManage.createTicket(ticket);
            System.out.println("parking successful");
        } else {
            System.out.println("Parking failed. No available spots.");
        }
    }

    private void carExit() {
        System.out.print("Enter Vehicle Number: ");
        String vehiclePlate = scanner.nextLine().trim().toUpperCase();

        if (vehiclePlate.isEmpty()) {
            System.out.println("Invalid vehicle number.");
            return;
        }

        ParkingTicket ticket = parkingLotManager.getTicket(vehiclePlate);
        if (ticket == null) {
            System.out.println("Vehicle not found in parking lot.");
            return;
        }

        // Calculate bill
        long duration = ticket.getParkingDuration();
        double amount = billingStrategy.calculateBill(duration);
        
        // Apply membership discount
        Driver driver = driverManager.findDriverByVehiclePlate(vehiclePlate);
        if (driver != null) {
            DiscountStrategy discount = getDiscountForMembership(driver.getMembershipType());
            if (discount != null) {
                amount = discount.applyDiscount(amount, driver);
            }
        }

        ticket.setAmount(amount);
        ticket.setExitTime(System.currentTimeMillis());

        System.out.println("Parking duration: " + formatDuration(duration));
        System.out.println("Amount due: $" + String.format("%.2f", amount));
        System.out.print("Process payment? (y/n): ");
        String response = scanner.nextLine().trim().toLowerCase();

        if (response.equals("y")) {
            // Create payment method (simplified - using cash as default)
            PaymentMethod paymentMethod = new Cash();
            
            // Process payment using command
            CMDMakePayment paymentCmd = new CMDMakePayment(ticket, paymentMethod, paymentProcessor, amount);
            driverInvoker.executeCommand(paymentCmd);

            if (ticket.isPaid()) {
                // Exit vehicle using command
                CMDPickupVehicle pickupCmd = new CMDPickupVehicle(vehiclePlate, parkingLotManager, ticketManage);
                driverInvoker.executeCommand(pickupCmd);
            }
        } else {
            System.out.println("Payment cancelled. Vehicle remains parked.");
        }
    }

    private void viewParkingLotStatus() {
        System.out.println("\nparking lot status:");
        parkingLotManager.displayParkingLot();
    }

    private DiscountStrategy getDiscountForMembership(MembershipType membershipType) {
        switch (membershipType) {
            case PREMIUM:
                return new PercentageDiscount(10); // 10% discount
            case VIP:
                return new PercentageDiscount(20); // 20% discount
            default:
                return null; // No discount for regular
        }
    }

    private String formatDuration(long millis) {
        long hours = millis / (1000 * 60 * 60);
        long minutes = (millis % (1000 * 60 * 60)) / (1000 * 60);
        return hours + " hours " + minutes + " minutes";
    }

    public static void main(String[] args) {
        SmartParkingSystem system = new SmartParkingSystem();
        system.run();
    }
}

// Simple Cash payment method
class Cash implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of $" + String.format("%.2f", amount) + " received in cash.");
    }
}

