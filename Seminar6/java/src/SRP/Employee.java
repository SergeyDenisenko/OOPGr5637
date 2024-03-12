package SRP;
import java.sql.Date;

public class Employee {
    private String name;
    private Date dob;
    private int salary;

    public Employee (String name, Date dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getEmpInfo() {
        return "name - " + name + " , dob - " + dob.toString();
    }

    public void takeSalary(int salary) {
        this.salary = salary;
    }
}
