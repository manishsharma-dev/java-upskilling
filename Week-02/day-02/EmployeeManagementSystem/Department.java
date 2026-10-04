import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Employee> employees = new ArrayList<>();

    public Department(String name){
        this.name = name;
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }

    public String removeEmployee(int employeeId){
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId() == employeeId) {
                employees.remove(i);
                return "Employee removed successfully";
            }
        }
        return "No employee found with the employee Id " + employeeId;
    }


    public void printAllEmployees(){
        for (Employee emp : this.employees){
            System.out.println(emp.getDetails());
        }
    }

    public void startWork() {
        for (Employee employee : employees) {
            System.out.println(employee.work());
        }
    }
}
