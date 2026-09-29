public abstract class Employee {

    private final int employeeId;
    private String name;
    private double salary;

    public Employee(int employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    public abstract String work();

    public int getEmployeeId() {
        return this.employeeId;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public String giveRaise(double percentage) {
        if (percentage <= 0 || percentage > 50) {
            return "Please enter a valid percentage for raise";
        }
        salary = salary + (salary * (percentage / 100));
        return "The new salary for " + name + " is: " + salary;
    }

    public String getDetails() {
        return this.employeeId + " : " + this.name + " : " + this.salary;
    }
}
