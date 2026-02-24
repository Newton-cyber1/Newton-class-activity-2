// Newton Murithi - 221025
// OOP Activity 2: Hospital Management System
public abstract class Person {
    protected String id;
    protected String name;
    protected String phone;
    protected static int totalPersons = 0;

    public Person(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        totalPersons++;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }

    public static int getTotalPersons() { return totalPersons; }

    public abstract String getRole();
}
