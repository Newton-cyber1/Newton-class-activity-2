// Newton Murithi - 221025
public class Appointment {
    private String appointmentId;
    private Doctor doctor;
    private Patient patient;
    private String date;
    private static int totalAppointments = 0;

    public Appointment(String appointmentId, Doctor doctor, Patient patient, String date) {
        this.appointmentId = appointmentId;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        totalAppointments++;
    }

    public String getAppointmentId() { return appointmentId; }
    public Doctor getDoctor() { return doctor; }
    public Patient getPatient() { return patient; }
    public String getDate() { return date; }
    public static int getTotalAppointments() { return totalAppointments; }

    public void scheduleAppointment() {
        System.out.println("Appointment " + appointmentId + " scheduled on " + date +
                " for " + patient.getName() + " with Dr. " + doctor.getName() + ".");
    }

    public void cancelAppointment() {
        System.out.println("Appointment " + appointmentId + " cancelled.");
    }
}
