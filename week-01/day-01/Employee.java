public class Employee {
    private String name;
    private double salary;

    private static int employeeCount = 0;
    
    private static final String COMPANY_NAME = "TechCorp";

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;

        employeeCount++;
    }

    public double getAnnualSalary(){
        return salary;
    }

    public void giveRaise(double percentage){
        salary =  salary + (salary * (percentage/100));
    }

    public void printDetails(){
        System.out.println("Employee " + this.name + "of " + COMPANY_NAME + " has salary of " + this.salary);
    }
}
