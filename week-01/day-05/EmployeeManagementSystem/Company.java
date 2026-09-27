import java.util.HashMap;
 
public class Company {
     private HashMap<Integer, Employee> empMap  = new HashMap<>();

     public void addEmployee(Employee employee){
        empMap.put(employee.getEmployeeId(), employee);
     }

     public Employee findEmployeeById(int employeeId){
        return empMap.get(employeeId);
     }
}
