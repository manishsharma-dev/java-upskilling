public class Employee {

    private final int employeeId;
    private String name;
    private double salary;

    public Employee(int employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) obj;
        return this.employeeId == other.employeeId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.employeeId);
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public String giveRaise(double percentage) {
        if (percentage <= 0 || percentage > 50) {
            throw new IllegalArgumentException("Raise percentage must be between 0 and 50");
        }
        salary = salary + (salary * (percentage / 100));
        return "The new salary for " + name + " is: " + salary;
    }

    public String getDetails() {
        return this.employeeId + " : " + this.name + " : " + this.salary;
    }
}
