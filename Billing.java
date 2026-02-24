// Newton Murithi - 221025
public class Billing implements Billable {
    private String billId;
    private Patient patient;
    private double amount;
    private boolean paid;

    public Billing(String billId, Patient patient, double amount) {
        this.billId = billId;
        this.patient = patient;
        this.amount = amount;
        this.paid = false;
    }

    public String getBillId() { return billId; }
    public double getAmount() { return amount; }
    public boolean isPaid() { return paid; }

    @Override
    public void generateBill() {
        System.out.println("Bill ID: " + billId);
        System.out.println("Patient: " + patient.getName() + " (" + patient.getId() + ")");
        System.out.println("Amount: KES " + amount);
        System.out.println("Status: " + (paid ? "PAID" : "UNPAID"));
    }

    @Override
    public void makePayment(double amount) {
        if (amount >= this.amount) {
            paid = true;
            System.out.println("Payment received: KES " + amount + ". Bill is now PAID.");
        } else {
            System.out.println("Payment received: KES " + amount + ". Balance: KES " + (this.amount - amount));
        }
    }
}
