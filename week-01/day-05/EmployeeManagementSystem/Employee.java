public class Employee {
   
    private final int employeeId;
    private String name;
    private double salary;

    public Employee(int employeeId, String name, double salary){
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    public String work(){
       return "Working";
    }

    public int getEmployeeId(){
        return this.employeeId;
    }

    public String getName(){
        return this.name;
    }

    public double getSalary(){
        return this.salary;
    }
    public String getDetails(){
       return this.employeeId + " : " + this.name + " : " + this.salary;
    }
}
