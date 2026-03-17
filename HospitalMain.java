import java.util.InputMismatchException;
import java.util.Scanner;

public class HospitalMain {

    private static String readNonEmpty(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) return value;
            System.out.println("Input cannot be empty. Try again.");
        }
    }

    private static double readDoubleMin(Scanner sc, String prompt, double min) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = sc.nextDouble();
                sc.nextLine();
                if (value < min) {
                    System.out.println("Enter a value of " + min + " or more.");
                    continue;
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid number (e.g., 1500 or 1500.50).");
                sc.nextLine();
            }
        }
    }

    private static int readIntRange(Scanner sc, String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = sc.nextInt();
                sc.nextLine();
                if (value < min || value > max) {
                    System.out.println("Enter a number between " + min + " and " + max + ".");
                    continue;
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid whole number.");
                sc.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("=== Hospital Management System ===");

            // Doctor input (matches Doctor constructor)
            String dId = readNonEmpty(sc, "Doctor ID: ");
            String dName = readNonEmpty(sc, "Doctor name: ");
            String dPhone = readNonEmpty(sc, "Doctor phone: ");
            String staffNo = readNonEmpty(sc, "Staff number: ");
            String dept = readNonEmpty(sc, "Department: ");
            String spec = readNonEmpty(sc, "Specialization: ");
            double fee = readDoubleMin(sc, "Consultation fee (KES): ", 0.0);

            Doctor doctor = new Doctor(dId, dName, dPhone, staffNo, dept, spec, fee);

            // Patient input (matches Patient constructor)
            String pId = readNonEmpty(sc, "\nPatient ID: ");
            String pName = readNonEmpty(sc, "Patient name: ");
            String pPhone = readNonEmpty(sc, "Patient phone: ");
            String illness = readNonEmpty(sc, "Illness: ");

            Patient patient = new Patient(pId, pName, pPhone, illness);

            System.out.println("\n--- Roles ---");
            System.out.println(doctor.getName() + " Role: " + doctor.getRole());
            System.out.println(patient.getName() + " Role: " + patient.getRole());

            doctor.performDuty();
            patient.admitPatient();

            // Appointment input (matches Appointment constructor)
            String apptId = readNonEmpty(sc, "\nAppointment ID: ");
            String date = readNonEmpty(sc, "Appointment date (e.g., 26 Feb 2026): ");

            Appointment appt = new Appointment(apptId, doctor, patient, date);
            doctor.scheduleAppointment(appt);

            // Billing input (matches Billing constructor)
            String billId = readNonEmpty(sc, "\nBill ID: ");
            double amount = readDoubleMin(sc, "Bill amount (KES): ", 0.0);

            Billing bill = new Billing(billId, patient, amount);

            System.out.println("\n--- Billing ---");
            bill.generateBill();

            double pay = readDoubleMin(sc, "Payment amount (KES): ", 0.0);
            bill.makePayment(pay);

            bill.generateBill();

            // Optional: cancel
            String cancel = readNonEmpty(sc, "\nCancel appointment? (yes/no): ").toLowerCase();
            if (cancel.equals("yes")) {
                doctor.cancelAppointment(appt);
            }

            patient.dischargePatient();

            System.out.println("\n--- Totals ---");
            System.out.println("Total persons: " + Person.getTotalPersons());
            System.out.println("Total patients: " + Patient.getTotalPatients());
            System.out.println("Total appointments: " + Appointment.getTotalAppointments());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("Program ended.");
        }
    }
}
