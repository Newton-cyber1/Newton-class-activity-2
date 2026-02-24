// Newton Murithi - 221025
public class Doctor extends Staff implements Schedulable {
    private String specialization;
    private double consultationFee;

    public Doctor(String id, String name, String phone, String staffNumber, String department,
                  String specialization, double consultationFee) {
        super(id, name, phone, staffNumber, department);
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    public String getSpecialization() { return specialization; }
    public double getConsultationFee() { return consultationFee; }

    @Override
    public String getRole() {
        return "Doctor";
    }

    @Override
    public void performDuty() {
        System.out.println("Doctor duty: Consulting and treating patients.");
    }

    @Override
    public void scheduleAppointment(Appointment appointment) {
        appointment.scheduleAppointment();
        System.out.println("Scheduled by Dr. " + getName());
    }

    @Override
    public void cancelAppointment(Appointment appointment) {
        appointment.cancelAppointment();
        System.out.println("Cancelled by Dr. " + getName());
    }
}
