import java.io.*;
import java.util.*;

public class HospitalStore {

    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();

    private Map<String, Patient> patientById = new HashMap<>();
    private Map<String, Doctor> doctorById = new HashMap<>();

    private Set<String> patientIds = new HashSet<>();
    private Set<String> doctorIds = new HashSet<>();

    public void addPatient(Patient p) {
        if (patientIds.contains(p.getId())) return;
        patients.add(p);
        patientById.put(p.getId(), p);
        patientIds.add(p.getId());
    }

    public void addDoctor(Doctor d) {
        if (doctorIds.contains(d.getId())) return;
        doctors.add(d);
        doctorById.put(d.getId(), d);
        doctorIds.add(d.getId());
    }

    public void addAppointment(Appointment a) {
        appointments.add(a);
    }

    public Patient findPatient(String id) {
        return patientById.get(id);
    }

    public Doctor findDoctor(String id) {
        return doctorById.get(id);
    }

    public ArrayList<Patient> getPatients() { return patients; }
    public ArrayList<Doctor> getDoctors() { return doctors; }
    public ArrayList<Appointment> getAppointments() { return appointments; }

    public void savePatients(String file) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (Patient p : patients) {
            bw.write(p.getId() + "," + p.getName() + "," + p.getPhone() + "," + p.getIllness());
            bw.newLine();
        }
        bw.close();
    }

    public void saveDoctors(String file) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (Doctor d : doctors) {
            bw.write(d.getId() + "," + d.getName() + "," + d.getPhone() + "," + d.getStaffNumber() + "," + d.getDepartment() + "," + d.getSpecialization() + "," + d.getConsultationFee());
            bw.newLine();
        }
        bw.close();
    }

    public void loadPatients(String file) throws IOException {
        File f = new File(file);
        if (!f.exists()) return;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            String[] x = line.split(",");
            if (x.length < 4) continue;
            Patient p = new Patient(x[0], x[1], x[2], x[3]);
            addPatient(p);
        }
        br.close();
    }

    public void loadDoctors(String file) throws IOException {
        File f = new File(file);
        if (!f.exists()) return;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            String[] x = line.split(",");
            if (x.length < 7) continue;
            Doctor d = new Doctor(x[0], x[1], x[2], x[3], x[4], x[5], Double.parseDouble(x[6]));
            addDoctor(d);
        }
        br.close();
    }
}
