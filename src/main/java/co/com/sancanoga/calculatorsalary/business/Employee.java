package co.com.sancanoga.calculatorsalary.business;

public class Employee {

    private long id;
    private String name;
    private String lastName;
    private double baseSalary;

    public Employee(long id, String name, String lastName, double baseSalary) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.baseSalary = baseSalary;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

}
