// Newton Murithi - 221025
public abstract class Staff extends Person {
    private String staffNumber;
    private String department;

    public Staff(String id, String name, String phone, String staffNumber, String department) {
        super(id, name, phone);
        this.staffNumber = staffNumber;
        this.department = department;
    }

    public String getStaffNumber() { return staffNumber; }
    public String getDepartment() { return department; }

    public abstract void performDuty();
}
