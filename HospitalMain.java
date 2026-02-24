// Newton Murithi - 221025
public class HospitalMain {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("D01", "Dr. Amina", "0700111222", "STF100", "Outpatient",
                "General Medicine", 1500.00);
        Patient patient = new Patient("P01", "Peter Mwangi", "0711222333", "Flu");

        System.out.println(doctor.getName() + " Role: " + doctor.getRole());
        System.out.println(patient.getName() + " Role: " + patient.getRole());

        doctor.performDuty();
        patient.admitPatient();

        Appointment appt = new Appointment("AP1001", doctor, patient, "26 Feb 2026");
        doctor.scheduleAppointment(appt);

        Billing bill = new Billing("B9001", patient, doctor.getConsultationFee());
        bill.generateBill();
        bill.makePayment(1500.00);
        bill.generateBill();

        doctor.cancelAppointment(appt);
        patient.dischargePatient();

        System.out.println("Total persons: " + Person.getTotalPersons());
        System.out.println("Total patients: " + Patient.getTotalPatients());
        System.out.println("Total appointments: " + Appointment.getTotalAppointments());
    }
}
