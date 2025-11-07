interface PaymentMethod {
    void pay(double amount);
}

class CreditCard implements PaymentMethod {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    @Override
    public void pay(double amount) {
        System.out.println("Paying with credit card: " + amount);
    }

    public CreditCard(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }
}

class DebitCard implements PaymentMethod {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    @Override
    public void pay(double amount) {
        System.out.println("Paying with debit card: " + amount);
    }

    public DebitCard(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }
}