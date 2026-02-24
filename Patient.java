// Newton Murithi - 221025
public class Patient extends Person {
    private String illness;
    private boolean admitted;
    private static int totalPatients = 0;

    public Patient(String id, String name, String phone, String illness) {
        super(id, name, phone);
        this.illness = illness;
        this.admitted = false;
        totalPatients++;
    }

    public String getIllness() { return illness; }
    public boolean isAdmitted() { return admitted; }
    public static int getTotalPatients() { return totalPatients; }

    public void admitPatient() {
        admitted = true;
        System.out.println("Patient " + name + " admitted.");
    }

    public void dischargePatient() {
        admitted = false;
        System.out.println("Patient " + name + " discharged.");
    }

    @Override
    public String getRole() {
        return "Patient";
    }
}
