package SRP;

public class Accounting {
    private int baseSalary;
    private double ratio = 0.25;

    public Accounting(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int calculateNetSalary() {
        int tax = (int) (baseSalary * ratio);
        return baseSalary - tax;
    }

    public void giveOutSalary(Employee employee) {
        employee.takeSalary(this.calculateNetSalary());
    }
}
